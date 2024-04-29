package com.manageo.reservation.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.manageo.reservation.domain.model.reservation.Reservation;
import com.manageo.reservation.domain.repository.ReservationRepository;

@Repository
public class H2ReservationRepository implements ReservationRepository {
	
	private final ReservationSpringRepository reservationSpringRepository;
	
	public H2ReservationRepository(ReservationSpringRepository reservationSpringRepository) {
		this.reservationSpringRepository = reservationSpringRepository;
	}


	@Override
	public Reservation save(Reservation reservation) {
		Assert.notNull(reservation, "reservation must not be null");
		return reservationSpringRepository.save(ReservationEntity.from(reservation)).toDomain();
	}

}
