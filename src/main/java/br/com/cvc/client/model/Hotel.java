package br.com.cvc.client.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hotel {
	
	private long id;
	private String name;
	private Integer cityCode;
	List<Rooms> rooms;

}
