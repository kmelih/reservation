package com.manageo.reservation.infrastructure.persistence;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.manageo.reservation.domain.model.reservation.RestaurantRepository;

@Repository
public class RestaurantWSRepository implements RestaurantRepository {

	@Autowired
	private RestTemplate restaurantService;

	@Value("${resource.url}")
	private String resourceUrl;

	@Override
	public int fetchTableAvailability(UUID restaurantId) {
		
		RestaurantResourceResponse resourceResponse = restaurantService.getForObject(resourceUrl+"/restaurants", RestaurantResourceResponse.class, restaurantId);
		
		return resourceResponse!=null? resourceResponse.getNbSeats() : 0;
	}

}
