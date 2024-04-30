package com.manageo.reservation.infrastructure.persistence.stub;

import java.util.UUID;

import com.manageo.reservation.domain.model.reservation.RestaurantRepository;

public class RestaurantWSStubRepository implements RestaurantRepository {

	@Override
	public int fetchTableAvailability(UUID uuid) {
		// TODO Auto-generated method stub
		return 10;
	}

}
