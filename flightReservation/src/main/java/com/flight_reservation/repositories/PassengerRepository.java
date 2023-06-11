package com.flight_reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flight_reservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
