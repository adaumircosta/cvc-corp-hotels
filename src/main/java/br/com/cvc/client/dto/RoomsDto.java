package br.com.cvc.client.dto;

import java.io.Serializable;
import lombok.Data;


@Data
public class RoomsDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private long roomId;
	private String categoryName;
	private Double totalPrice;
	private PriceDetailDto priceDetailDto;
}
