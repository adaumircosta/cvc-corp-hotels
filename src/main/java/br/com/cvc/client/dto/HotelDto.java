package br.com.cvc.client.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class HotelDto implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String cityName;
	private List<RoomsDto> rooms;

}
