package br.com.cvc.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class HotelsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public HotelsException(String msg) {
        super(msg);
    }
}
