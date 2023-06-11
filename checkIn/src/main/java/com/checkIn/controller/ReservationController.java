package com.checkIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.checkIn.integration.ReservationRestfulClient;
import com.checkIn.payloads.Reservation;
import com.checkIn.payloads.ReservationUpdateRequest;


@Controller
public class ReservationController {
	
	@Autowired
	private ReservationRestfulClient restClient;

	@RequestMapping("/startCheckIn")
	public String startCheckIn() {
		return "startCheckIn";
	}

	@RequestMapping("/proceedCheckIn")
	public String proceedCheckIn(@RequestParam("id") Long id, ModelMap model) {
		Reservation reservation = restClient.findReservation(id);
		model.addAttribute("reservation", reservation);
		return "displayResrvation";
	}

	@RequestMapping("/proceedToCheckIn")
	public String proceedToCheckIn(@RequestParam("id") Long id, @RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest request = new ReservationUpdateRequest();
		request.setId(id);
		request.setNumberOfBags(numberOfBags);
		request.setCheckInStatus(true);
		restClient.updateReservation(request);
		return "confirmReservation";
	}
}
