package com.manageo.reservation.domain.model.reservation;

import java.util.UUID;

public class ReservationId {

	private UUID id;

	public ReservationId(UUID id) {
		this.id = build(id);
	}

	private UUID build(UUID id) {
		if (id == null) {
			return UUID.randomUUID();
		}
		return id;
	}

	public UUID getId() {
		return id;
	}


}
