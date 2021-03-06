package br.com.cvc.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.cvc.client.exception.HotelsException;
import br.com.cvc.client.model.Hotel;

@Service
public class BrokerService {

	private static final String url = "https://cvcbackendhotel.herokuapp.com/hotels/";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MessagesService message;

	public List<Hotel> HotelsPriceByIdCity(long idCity) {
		String caminho = url + "avail/" + Long.toString(idCity);
		
		try {
			ResponseEntity<List<Hotel>> responseEntity = restTemplate.exchange(caminho, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Hotel>>() {});
			return responseEntity.getBody();
		} catch (RestClientException e) {
			throw new HotelsException(message.get("error.get.hotels"));
		}

	}

	public Hotel HotelsPriceByIdHotel(long idHotel) {
		String caminho = url + Long.toString(idHotel);
		
		try {
			ResponseEntity<List<Hotel>> responseEntity = restTemplate.exchange(caminho, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Hotel>>() {
					});
			return responseEntity.getBody().get(0);
		} catch (RestClientException e) {
			throw new HotelsException(message.get("error.get.hotels"));
		}
		

	}

}
