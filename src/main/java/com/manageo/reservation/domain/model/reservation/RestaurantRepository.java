package com.manageo.reservation.domain.model.reservation;

import java.util.UUID;

public interface RestaurantRepository {

	int fetchTableAvailability(UUID uuid);

}
