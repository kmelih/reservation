package com.manageo.reservation.infrastructure.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manageo.reservation.domain.model.reservation.Reservation;

public interface ReservationSpringRepository extends JpaRepository<ReservationEntity, UUID> {



}
