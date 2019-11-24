package br.com.cvc.client.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Travel {
	
	@Positive(message = "{travel.code.positive}")
	@NotBlank(message = "{travel.code.notblank}")
	@NotNull(message = "{travel.code.notnull}")
	private Integer code;
	
	@NotNull(message = "{travel.checkin.notnull}")
	@NotBlank(message = "{travel.checkin.notblank}")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate checkin;
	
	@NotNull(message = "{travel.checkout.notnull}")
	@NotBlank(message = "{travel.checkout.notblank}")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate checkout;
	
	@Positive(message = "{travel.quantitybyadult.positive}")
	@NotNull(message = "{travel.quantitybyadult.notnull}")
	@NotBlank(message = "{travel.quantitybyadult.notblank}")
	private Integer quantityByAdult;
	
	@Positive(message = "{travel.quantitybychild.positive}")
	@NotBlank(message = "{travel.quantitybychild.notblank}")
	@NotNull(message = "{travel.quantitybychild.notnull}")
	private Integer quantityByChild;
	
}
