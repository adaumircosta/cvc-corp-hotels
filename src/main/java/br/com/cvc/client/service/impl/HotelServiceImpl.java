package br.com.cvc.client.service.impl;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cvc.client.dto.HotelDto;
import br.com.cvc.client.dto.PriceDetailDto;
import br.com.cvc.client.dto.RoomsDto;
import br.com.cvc.client.model.Hotel;
import br.com.cvc.client.model.Rooms;
import br.com.cvc.client.model.Travel;
import br.com.cvc.client.service.BrokerService;
import br.com.cvc.client.service.HotelService;

public class HotelServiceImpl implements HotelService {

	@Autowired
	private BrokerService brokerApi;

	@Override
	public List<HotelDto> StayByCity(Travel travel) {
		List<HotelDto> hotelDtos = new ArrayList<>();
		List<Hotel> hotels = brokerApi.HotelsPriceByIdCity(travel.getCode().intValue());
		Long qtdDays = ChronoUnit.DAYS.between(travel.getCheckin(), travel.getCheckout());
		
		hotels.forEach(hotel -> {
			hotelDtos.add(calculateStay(hotel, qtdDays.intValue()));
		});

		return hotelDtos;
	}

	@Override
	public HotelDto StayByHotel(Travel travel) {
		HotelDto hotelDto = new HotelDto();
		Long qtdDays = ChronoUnit.DAYS.between(travel.getCheckin(), travel.getCheckout());
		Hotel hotel = brokerApi.HotelsPriceByIdHotel(travel.getCode().intValue());
		hotelDto = calculateStay(hotel, qtdDays.intValue());
		return hotelDto;
	}

	private HotelDto calculateStay(Hotel hotel, Integer qtdDays) {
		HotelDto hotelDto = new HotelDto();
		hotelDto.setId(hotel.getId());
		hotelDto.setCityName(hotel.getCityName());
		hotelDto.setRooms(calculateRooms(hotel.getRooms(), qtdDays.intValue()));
		return hotelDto;

	}

	private  List<RoomsDto> calculateRooms(List<Rooms> rooms, Integer qtdDays) {
		List<RoomsDto> roomsDtos = new ArrayList<>();
		rooms.forEach(room -> {
			
			RoomsDto roomsDto = new RoomsDto();
			roomsDto.setRoomId(room.getRoomId());
			roomsDto.setCategoryName(room.getCategoryName());
			
			PriceDetailDto priceDetailDto = new PriceDetailDto();
			priceDetailDto.setPricePerDayAdult(room.getPrice().getAdult() * qtdDays);
			priceDetailDto.setPricePerDayChild(room.getPrice().getChild() * qtdDays);
			roomsDto.setPriceDetailDto(priceDetailDto);
			roomsDto.setTotalPrice(priceDetailDto.getPricePerDayAdult() + priceDetailDto.getPricePerDayChild());
		});
		return roomsDtos;
	}

}
