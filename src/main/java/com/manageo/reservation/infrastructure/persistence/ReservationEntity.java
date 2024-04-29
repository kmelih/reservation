package com.manageo.reservation.infrastructure.persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

import com.manageo.reservation.domain.model.reservation.Customer;
import com.manageo.reservation.domain.model.reservation.Note;
import com.manageo.reservation.domain.model.reservation.Reservation;
import com.manageo.reservation.domain.model.reservation.ReservationDate;
import com.manageo.reservation.domain.model.reservation.ReservationId;
import com.manageo.reservation.domain.model.reservation.ReservationStatus;
import com.manageo.reservation.domain.model.reservation.RestaurantId;
import com.manageo.reservation.domain.model.reservation.Seat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservation")
class ReservationEntity {

	@Id
	@Column(name = "reservation")
	private UUID id;

	@Column(name = "notes")
	private String notes;

	@Column(name = "nb_seats")
	private int nbSeats;

	@Column(name = "restaurant")
	private UUID restaurantId;

	@Column(name = "first_name_customer")
	private String firstNameCustomer;

	@Column(name = "last_name_customer")
	private String lastNameCustomer;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private ReservationStatus status;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "time")
	private LocalTime time;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	ReservationEntity id(UUID id) {
		this.id = id;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	ReservationEntity notes(String notes) {
		this.notes = notes;
		return this;
	}

	public int getNbSeats() {
		return nbSeats;
	}

	ReservationEntity nbSeats(int nbSeats) {
		this.nbSeats = nbSeats;
		return this;
	}

	public void setNbSeats(int nbSeats) {
		this.nbSeats = nbSeats;
	}

	public UUID getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(UUID restaurantId) {
		this.restaurantId = restaurantId;
	}

	ReservationEntity restaurantId(UUID restaurantId) {
		this.restaurantId = restaurantId;
		return this;
	}

	public String getFirstNameCustomer() {
		return firstNameCustomer;
	}

	public void setFirstNameCustomer(String firstNameCustomer) {
		this.firstNameCustomer = firstNameCustomer;
	}

	ReservationEntity firstNameCustomer(String firstNameCustomer) {
		this.firstNameCustomer = firstNameCustomer;
		return this;
	}

	public String getLastNameCustomer() {
		return lastNameCustomer;
	}

	public void setLastNameCustomer(String lastNameCustomer) {
		this.lastNameCustomer = lastNameCustomer;
	}

	ReservationEntity lastNameCustomer(String lastNameCustomer) {
		this.lastNameCustomer = lastNameCustomer;
		return this;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	ReservationEntity status(ReservationStatus status) {
		this.status = status;
		return this;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ReservationEntity date(LocalDate date) {
		this.date = date;
		return this;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public ReservationEntity time(LocalTime time) {
		this.time = time;
		return this;
	}

	public static ReservationEntity from(Reservation reservation) {
		return new ReservationEntity().id(reservation.getReservationId().getId())
				.notes(reservation.getNotes().getContent()).nbSeats(reservation.getSeat().getSeatNumber())
				.restaurantId(reservation.getRestaurantId().getId())
				.firstNameCustomer(reservation.getCustomer().getFirstName())
				.lastNameCustomer(reservation.getCustomer().getLastName()).status(reservation.getStatus())
				.time(reservation.getReservationDate().getTime()).date(reservation.getReservationDate().getDate());
	}

	public Reservation toDomain() {
		return new Reservation.ReservationBuilder().reservationId(new ReservationId(getId())).note(new Note(getNotes()))
				.Seat(new Seat(getNbSeats())).restaurantId(new RestaurantId(getRestaurantId()))
				.customer(new Customer(getFirstNameCustomer(), getLastNameCustomer()))
				.reservationDate(new ReservationDate(getDate(), getTime())).build();
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, firstNameCustomer, id, lastNameCustomer, nbSeats, notes, restaurantId, status, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationEntity other = (ReservationEntity) obj;
		return Objects.equals(date, other.date) && Objects.equals(firstNameCustomer, other.firstNameCustomer)
				&& Objects.equals(id, other.id) && Objects.equals(lastNameCustomer, other.lastNameCustomer)
				&& nbSeats == other.nbSeats && Objects.equals(notes, other.notes)
				&& Objects.equals(restaurantId, other.restaurantId) && status == other.status
				&& Objects.equals(time, other.time);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	

}
