package br.com.cvc.client.dto;

import java.io.Serializable;
import lombok.Data;


@Data
public class RoomsDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private long roomID;
	private String categoryName;
	private Double totalPrice;
	private PriceDetail priceDetail;
}
