package br.com.cvc.client.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.client.dto.HotelDto;
import br.com.cvc.client.model.Travel;
import br.com.cvc.client.service.HotelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Hotel Controller")
@RestController
@RequestMapping(value = "api/price", produces = "application/json")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping(value = "/city")
    @ApiOperation(value = "Retorna a lista de hoteis pelo id da cidade")
	public List<HotelDto> calculateDailyByCity(@Valid Travel travel){
		return hotelService.StayByCity(travel);
	}
	
	@GetMapping(value = "/hotel")
    @ApiOperation(value = "Retorna a lista de hoteis pelo id do hotel ")
	public HotelDto calculateDailyByHotel(@Valid Travel travel) {
		return hotelService.StayByHotel(travel);
	}
	
	

}
