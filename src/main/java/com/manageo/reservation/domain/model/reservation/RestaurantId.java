package com.manageo.reservation.domain.model.reservation;

import java.util.UUID;

public class RestaurantId {

	private UUID id;

	public RestaurantId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

}
