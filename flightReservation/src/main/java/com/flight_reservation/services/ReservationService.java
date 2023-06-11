package com.flight_reservation.services;

import com.flight_reservation.entities.Reservation;
import com.flight_reservation.payloads.ReservationRequest;

public interface ReservationService {
	Reservation bookFlight(ReservationRequest request);
}
