package com.manageo.reservation.domain.model.reservation;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservationTest {

	private Reservation reservation;

	@BeforeEach
	public void setUp() {
		reservation = new Reservation.ReservationBuilder()
				.reservationDate(new ReservationDate(LocalDate.of(2024, 4, 29), LocalTime.of(20, 0))).build();
	}

	@Test
	void shouldReservationHasReservationDate() {
		assertThat(reservation).extracting(Reservation::getReservationDate).isNotNull();
		assertThat(reservation).extracting(Reservation::getReservationDate).extracting(ReservationDate::getDate)
				.isEqualTo(LocalDate.of(2024, 4, 29));
		assertThat(reservation).extracting(Reservation::getReservationDate).extracting(ReservationDate::getTime)
				.isEqualTo(LocalTime.of(20, 0));
	}
	
	@Test
	void shouldReservationStatusBeApprovedWhenReservationIsApproved() {
		
		reservation.approve();
		
		assertThat(reservation).extracting(Reservation::getStatus).isEqualTo(ReservationStatus.APPROVED);
	}

}
