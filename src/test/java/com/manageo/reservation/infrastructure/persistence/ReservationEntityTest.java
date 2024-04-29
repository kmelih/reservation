package com.manageo.reservation.infrastructure.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manageo.reservation.domain.model.reservation.Customer;
import com.manageo.reservation.domain.model.reservation.Note;
import com.manageo.reservation.domain.model.reservation.Reservation;
import com.manageo.reservation.domain.model.reservation.ReservationDate;
import com.manageo.reservation.domain.model.reservation.ReservationId;
import com.manageo.reservation.domain.model.reservation.RestaurantId;
import com.manageo.reservation.domain.model.reservation.Seat;

class ReservationEntityTest {

	private static final String NOTES = "vegetarian food";
	private static final String CUSTOMER_LASTNAME = "Martin";
	private static final String CUSTOMER_FIRSTNAME = "Jean";
	private static final String RESTAURANT_ID = "82d52192-5d6a-41e2-a7ed-f05df9e56185";
	private static final String RESERVATION_ID = "1a9fc995-3583-4b81-ad61-7f3c19ce96ec";
	private Reservation reservation;

	@BeforeEach
	void setUp() {
		reservation = new Reservation.ReservationBuilder().reservationId(new ReservationId(UUID.fromString(RESERVATION_ID))).restaurantId(new RestaurantId(UUID.fromString(RESTAURANT_ID)))
				.customer(new Customer(CUSTOMER_FIRSTNAME, CUSTOMER_LASTNAME)).note(new Note(NOTES))
				.reservationDate(new ReservationDate(LocalDate.of(2024, 04, 29), LocalTime.of(20, 0))).Seat(new Seat(4))
				.build();
	}

	@Test
	void shouldConvertFromAndToReservation() {
		assertThat(ReservationEntity.from(reservation).toDomain()).usingRecursiveComparison().isEqualTo(reservation);
	}

}
