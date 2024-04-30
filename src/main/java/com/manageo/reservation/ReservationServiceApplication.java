package com.manageo.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.manageo.reservation.domain.model.reservation.RestaurantRepository;
import com.manageo.reservation.infrastructure.persistence.RestaurantResourceResponse;
import com.manageo.reservation.infrastructure.persistence.stub.RestaurantWSStubRepository;

@SpringBootApplication
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}
	
	  @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

	  
	  @Bean
	  public RestaurantRepository restaurantRepository(){
		  return new RestaurantWSStubRepository();
	  }

}
