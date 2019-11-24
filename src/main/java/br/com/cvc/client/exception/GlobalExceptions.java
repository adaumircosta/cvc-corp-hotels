package br.com.cvc.client.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<Map<String, Object>> yourExceptionHandler(MethodArgumentNotValidException e) {
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, String> errors = new HashMap<String, String>();
        
        errors.put("message: ", "Existem campos invalidos");
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        response.put("erros", errors);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    }
	
	

}
