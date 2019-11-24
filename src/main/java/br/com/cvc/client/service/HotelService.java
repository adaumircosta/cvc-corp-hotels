package br.com.cvc.client.service;

import java.util.List;

import br.com.cvc.client.dto.HotelDto;

public interface HotelService {
	
	public List<HotelDto> calculateStay();
	
	//public HotelDto calculateStayByHotel();

}
