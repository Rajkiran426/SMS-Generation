 package com.flight_reservation.controllers;


import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.flight_reservation.entities.Flight;
import com.flight_reservation.repositories.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepo;

	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") Date departureDate, ModelMap model) {
		List<Flight> findFlights = flightRepo.findFlights(from, to, departureDate);
		model.addAttribute("findFlights", findFlights);
		return "displayFlights";
	}

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap model) {
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		model.addAttribute("flight", flight);
		return "showReservation";
	}
}