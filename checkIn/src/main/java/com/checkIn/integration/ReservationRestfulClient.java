package com.checkIn.integration;

import org.springframework.web.bind.annotation.RequestBody;

import com.checkIn.payloads.Reservation;
import com.checkIn.payloads.ReservationUpdateRequest;


public interface ReservationRestfulClient {
	
	public Reservation findReservation(Long id);

	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request);
}
