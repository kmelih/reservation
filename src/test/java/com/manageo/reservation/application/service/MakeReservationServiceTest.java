package com.manageo.reservation.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.manageo.reservation.domain.model.reservation.MakeReservationUseCase;
import com.manageo.reservation.domain.model.reservation.Reservation;
import com.manageo.reservation.domain.model.reservation.ReservationDate;
import com.manageo.reservation.domain.model.reservation.ReservationId;
import com.manageo.reservation.domain.repository.ReservationRepository;

@ExtendWith(MockitoExtension.class)
class MakeReservationServiceTest {

	@Mock
	private ReservationRepository reservationRepository;

	private MakeReservationUseCase makeReservationUseCase;

	@Captor
	ArgumentCaptor<Reservation> reservationCaptor;

	@BeforeEach
	public void setUp() {
		makeReservationUseCase = new MakeReservationService(reservationRepository);
	}

	@Test
	void shouldReservationHasReservationIdNotNull() {
		// Given
		Reservation reservation = new Reservation.ReservationBuilder().reservationId(new ReservationId(null))
				.reservationDate(new ReservationDate(LocalDate.of(2024, 4, 29), LocalTime.of(20, 0))).build();
		when(reservationRepository.save(Mockito.any(Reservation.class))).thenReturn(reservation);

		// When
		reservation = makeReservationUseCase.apply(reservation);

		// Then
		verify(reservationRepository).save(reservationCaptor.capture());
		
		Reservation captorValue = reservationCaptor.getValue();
		// On verifie que l'objet en entrée et le même que l'on passe à la méthode save
		assertThat(captorValue).usingRecursiveAssertion().isEqualTo(reservation);
		assertThat(reservation).isNotNull();
	}

}
