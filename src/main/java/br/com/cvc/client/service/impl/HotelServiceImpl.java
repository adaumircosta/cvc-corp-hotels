package br.com.cvc.client.service.impl;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.client.dto.HotelDto;
import br.com.cvc.client.dto.PriceDetail;
import br.com.cvc.client.dto.RoomsDto;
import br.com.cvc.client.exception.HotelsException;
import br.com.cvc.client.model.Hotel;
import br.com.cvc.client.model.Rooms;
import br.com.cvc.client.model.Travel;
import br.com.cvc.client.service.BrokerService;
import br.com.cvc.client.service.HotelService;
import br.com.cvc.client.service.MessagesService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private BrokerService brokerApi;
	
	@Autowired
	private MessagesService message;

	@Override
	public List<HotelDto> StayByCity(Travel travel) {
		List<HotelDto> hotelDtos = new ArrayList<>();
		List<Hotel> hotels = brokerApi.HotelsPriceByIdCity(travel.getCode().intValue());
		Long qtdDays = ChronoUnit.DAYS.between(travel.getCheckin(), travel.getCheckout());
		if (qtdDays < 0) {
			throw new HotelsException(message.get("datafim.menorquea.datainicial"));
		}

		hotels.forEach(hotel -> {
			hotelDtos.add(calculateStay(hotel, qtdDays.intValue(), travel.getQuantityByAdult(), travel.getQuantityByChild()));
		});

		return hotelDtos;
	}

	@Override
	public HotelDto StayByHotel(Travel travel) {
		HotelDto hotelDto = new HotelDto();
		Long qtdDays = ChronoUnit.DAYS.between(travel.getCheckin(), travel.getCheckout());
		Hotel hotel = brokerApi.HotelsPriceByIdHotel(travel.getCode().intValue());
		hotelDto = calculateStay(hotel, qtdDays.intValue(), travel.getQuantityByAdult(), travel.getQuantityByChild());
		return hotelDto;
	}

	private HotelDto calculateStay(Hotel hotel, Integer qtdDays, Integer qtdAduls, Integer qtdChilds) {
		HotelDto hotelDto = new HotelDto();
		List<RoomsDto> rooms = new ArrayList<>();
		hotelDto.setId(hotel.getId());
		hotelDto.setCityName(hotel.getCityName());
		hotel.getRooms().forEach(room -> {
			rooms.add(calculateRooms(room, qtdDays, qtdAduls, qtdChilds));
		});
		hotelDto.setRooms(rooms);
		return hotelDto;

	}

	private RoomsDto calculateRooms(Rooms rooms, Integer qtdDays, Integer qtdAduls, Integer qtdChilds) {
		RoomsDto roomsDto = new RoomsDto();
		PriceDetail priceDetail = new PriceDetail();
		
		roomsDto.setRoomID(rooms.getRoomID());
		roomsDto.setCategoryName(rooms.getCategoryName());

		priceDetail.setPricePerDayAdult(rooms.getPrice().getAdult() * qtdDays);
		priceDetail.setPricePerDayChild(rooms.getPrice().getChild() * qtdDays);
		roomsDto.setPriceDetail(priceDetail);
		Double priceTotalAdults = DoubleRounder.round(priceDetail.getPricePerDayAdult() * qtdAduls, 2);
		Double priceTotalChilds = DoubleRounder.round(priceDetail.getPricePerDayChild() * qtdChilds, 2);
		roomsDto.setTotalPrice(priceTotalAdults  + priceTotalChilds);
		return roomsDto;
	}

}
