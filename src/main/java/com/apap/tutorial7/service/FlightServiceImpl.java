package com.apap.tutorial7.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;
	
	@Override
	public FlightModel addFlight(FlightModel flight) {
		flightDb.save(flight);
		return flight;
	}
	
	@Override
	public void deleteFlight(long id) {
		FlightModel flight =flightDb.findById(id).get();
		flightDb.delete(flight);
	}
	
	@Override
	public FlightModel getFlightDetail(Long id) {
		return flightDb.findById(id).get();
	}
	
	@Override
	public FlightModel getFlightDetailNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}
	
	
	
	@Override
	public void updateFlight(FlightModel newFlight,long id){
		FlightModel oldFlight= this.getFlightDetail(id);
		
		oldFlight.setFlightNumber(newFlight.getFlightNumber());
		oldFlight.setOrigin(newFlight.getOrigin());
		oldFlight.setDestination(newFlight.getDestination());
		oldFlight.setTime(newFlight.getTime());
		
	}
	
	public List<FlightModel> viewAllFlight(){
		return flightDb.findAll();
	}
	
}
