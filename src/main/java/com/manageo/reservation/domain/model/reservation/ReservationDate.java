package com.manageo.reservation.domain.model.reservation;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationDate {
	
	private final LocalDate date;
	
	private final LocalTime time;

	public ReservationDate(LocalDate date, LocalTime time) {
		this.date = date;
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getTime() {
		return time;
	}
	
	

}
