package com.manageo.reservation.application.service;

import org.springframework.stereotype.Service;

import com.manageo.reservation.domain.model.reservation.CheckAvailabilityTableUseCase;
import com.manageo.reservation.domain.model.reservation.Reservation;
import com.manageo.reservation.domain.model.reservation.RestaurantRepository;

@Service
public class CheckAvailabilityTableService implements CheckAvailabilityTableUseCase {

	private final RestaurantRepository restaurantRepository;
	
	public CheckAvailabilityTableService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public boolean apply(Reservation reservation) {
		
		int nbSeats = restaurantRepository.fetchTableAvailability(reservation.getRestaurantId().getId());
		return nbSeats> reservation.getSeat().getSeatNumber();
	}

}
