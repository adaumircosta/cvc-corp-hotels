package br.com.cvc.client.dto;

import java.io.Serializable;

import org.decimal4j.util.DoubleRounder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PriceDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double pricePerDayAdult;
	private Double pricePerDayChild;
	
	public void setPricePerDayAdult(Double pricePerDayAdult) {
		this.pricePerDayAdult = DoubleRounder.round(pricePerDayAdult / 0.7, 2);
	}
	public void setPricePerDayChild(Double pricePerDayChild) {
		this.pricePerDayChild = DoubleRounder.round(pricePerDayChild / 0.7, 2);
	}
	
	

}
