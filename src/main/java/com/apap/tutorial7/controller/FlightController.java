package com.apap.tutorial7.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.service.FlightService;
import com.apap.tutorial7.service.PilotService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightService flightService;

	@Autowired
	private PilotService pilotService;

	@PostMapping(value = "/add")
	public FlightModel addFlightSubmit(@RequestBody FlightModel flight) {
		return flightService.addFlight(flight);
	}

	@GetMapping(value = "/view/{flightNumber}")
	public FlightModel flightView(@PathVariable("flightNumber") String flightNumber) {
		FlightModel flight = flightService.getFlightDetailNumber(flightNumber);
		return flight;
	}

	@DeleteMapping(value = "/{flightId}")
	public String deleteFlight(@PathVariable("flightId") long flightId, Model model) {
		flightService.deleteFlight(flightId);
		return "flight has been deleted";
	}

	@PutMapping(value = "/update/{flightId}")
	public String updatePilotSubmit(@PathVariable("flightId") long flightId,
			@RequestParam("destination") Optional<String> destination, @RequestParam("origin") Optional<String> origin,
			@RequestParam("time") Optional <Date> time) {
		FlightModel flight = flightService.getFlightDetail(flightId);
		if (flight.equals(null)) {
			return "Couldn't find your flight";
		}

		if (destination.isPresent()) {
			flight.setDestination(destination.get());
		}

		if (origin.isPresent()) {
			flight.setOrigin(origin.get());
		}
		
		if(origin.isPresent()) {
			flight.setTime(time.get());
		}
		
		flightService.updateFlight(flight, flightId);
		return "flight update success";

	}

	@GetMapping()
	private List<FlightModel> viewAllFlight(Model model) {
		return flightService.viewAllFlight();
	}

}
