package com.manageo.reservation.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.manageo.reservation.domain.model.reservation.Customer;
import com.manageo.reservation.domain.model.reservation.Note;
import com.manageo.reservation.domain.model.reservation.Reservation;
import com.manageo.reservation.domain.model.reservation.ReservationDate;
import com.manageo.reservation.domain.model.reservation.ReservationId;
import com.manageo.reservation.domain.model.reservation.RestaurantId;
import com.manageo.reservation.domain.model.reservation.Seat;

@SpringBootTest
class CheckAvailabilityTableServiceIT {

	private static final String NOTES = "vegetarian food";
	private static final String CUSTOMER_LASTNAME = "Martin";
	private static final String CUSTOMER_FIRSTNAME = "Jean";
	private static final String RESTAURANT_ID = "82d52192-5d6a-41e2-a7ed-f05df9e56185";
	private static final String RESERVATION_ID = "1a9fc995-3583-4b81-ad61-7f3c19ce96ec";

	@Autowired
	private CheckAvailabilityTableService availabilityTableService;

	private Reservation reservation;

	@BeforeEach
	void setUp() {
		reservation = new Reservation.ReservationBuilder()
				.reservationId(new ReservationId(UUID.fromString(RESERVATION_ID)))
				.restaurantId(new RestaurantId(UUID.fromString(RESTAURANT_ID)))
				.customer(new Customer(CUSTOMER_FIRSTNAME, CUSTOMER_LASTNAME)).note(new Note(NOTES))
				.reservationDate(new ReservationDate(LocalDate.of(2024, 04, 29), LocalTime.of(20, 0))).Seat(new Seat(4))
				.build();
	}

	@Test
	void shouldReturnWhenReservationFor4SeatsAndAvailabiltyOf10() {
		boolean isAvailable = availabilityTableService.apply(reservation);
		
		assertThat(isAvailable).isTrue();
	}

}
