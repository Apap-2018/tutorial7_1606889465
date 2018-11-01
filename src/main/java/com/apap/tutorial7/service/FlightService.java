package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.PilotModel;

public interface FlightService {
	FlightModel getFlightDetail(Long id);
	FlightModel getFlightDetailNumber(String flightNumber);
	FlightModel addFlight(FlightModel flight);
	List<FlightModel> viewAllFlight();
	void deleteFlight(long id);
	void updateFlight(FlightModel newFlight, long id);
}
