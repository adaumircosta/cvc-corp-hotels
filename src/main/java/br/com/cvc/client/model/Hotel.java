package br.com.cvc.client.model;

import java.util.List;

import lombok.Data;

@Data
public class Hotel {
	
	private long id;
	private String name;
	private Integer cityCode;
	private String cityName;
	List<Rooms> rooms;

}
