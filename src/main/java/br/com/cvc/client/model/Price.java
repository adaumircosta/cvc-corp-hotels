package br.com.cvc.client.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Price implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Double adult;
	private Double child;
}
