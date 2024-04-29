package com.manageo.reservation.domain.repository;

import com.manageo.reservation.domain.model.reservation.Reservation;

public interface ReservationRepository {
	
	public Reservation save (Reservation reservation);

}
