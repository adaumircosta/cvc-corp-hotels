package br.com.cvc.client.service;

import java.util.List;

import br.com.cvc.client.dto.HotelDto;
import br.com.cvc.client.model.Travel;

public interface HotelService {
	
	public List<HotelDto> StayByCity(Travel travel);
	
	public HotelDto StayByHotel(Travel travel);

}
