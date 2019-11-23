package br.com.cvc.client.model;

import lombok.Data;

@Data
public class Rooms {
	
	private long roomId;
	private String categoryName;
	private Price price;

}
