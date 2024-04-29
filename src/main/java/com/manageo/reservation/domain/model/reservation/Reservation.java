package com.manageo.reservation.domain.model.reservation;

public class Reservation {

	private final ReservationId reservationId;

	private final ReservationDate reservationDate;

	private final Note notes;

	private final Seat seat;

	private final RestaurantId restaurantId;

	private final Customer customer;

	private final ReservationStatus status;

	public Reservation(ReservationBuilder reservationBuilder) {
		this.reservationId = reservationBuilder.getReservationId();
		this.reservationDate = reservationBuilder.getReservationDate();
		this.notes = reservationBuilder.getNotes();
		this.seat = reservationBuilder.getSeat();
		this.restaurantId = reservationBuilder.getRestaurantId();
		this.customer = reservationBuilder.getCustomer();
		this.status = ReservationStatus.PENDING;
	}

	public ReservationId getReservationId() {
		return reservationId;
	}

	public ReservationDate getReservationDate() {
		return reservationDate;
	}

	public Note getNotes() {
		return notes;
	}

	public Seat getSeat() {
		return seat;
	}

	public RestaurantId getRestaurantId() {
		return restaurantId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	static public class ReservationBuilder {

		private ReservationId reservationId;

		private ReservationDate reservationDate;

		private Note notes;

		private Seat seat;

		private RestaurantId restaurantId;

		private Customer customer;

		public ReservationBuilder reservationId(ReservationId id) {
			this.reservationId = id;
			return this;
		}

		public ReservationBuilder reservationDate(ReservationDate reservationDate) {
			this.reservationDate = reservationDate;
			return this;
		}

		public ReservationBuilder note(Note notes) {
			this.notes = notes;
			return this;
		}

		public ReservationBuilder Seat(Seat seat) {
			this.seat = seat;
			return this;
		}

		public ReservationBuilder restaurantId(RestaurantId restaurantId) {
			this.restaurantId = restaurantId;
			return this;
		}

		public ReservationBuilder customer(Customer customer) {
			this.customer = customer;
			return this;
		}

		public Reservation build() {
			return new Reservation(this);
		}

		public ReservationId getReservationId() {
			return reservationId;
		}

		public ReservationDate getReservationDate() {
			return reservationDate;
		}

		public Note getNotes() {
			return notes;
		}

		public Seat getSeat() {
			return seat;
		}

		public RestaurantId getRestaurantId() {
			return restaurantId;
		}

		public Customer getCustomer() {
			return customer;
		}
	}

	public void approve() {
		// TODO

	}

	public void disapprove() {
		// TODO

	}

}
