package com.manageo.reservation.application.service;

import org.springframework.stereotype.Service;

import com.manageo.reservation.domain.model.reservation.MakeReservationUseCase;
import com.manageo.reservation.domain.model.reservation.Reservation;
import com.manageo.reservation.domain.repository.ReservationRepository;

@Service
public class MakeReservationService implements MakeReservationUseCase {

	private  final ReservationRepository reservationRepository;
	
	public MakeReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@Override
	public Reservation apply(Reservation reservation) {
		//TODO call CheckAvailabilityService
		return reservationRepository.save(reservation);
		
	}
	

}
