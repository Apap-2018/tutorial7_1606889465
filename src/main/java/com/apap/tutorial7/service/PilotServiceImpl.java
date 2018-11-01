package com.apap.tutorial7.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.repository.PilotDb;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDb pilotDb;
	
	@Override 
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public PilotModel getPilotDetailById(Long id) {
		return pilotDb.findById(id).get();
	}
	
	@Override
	public PilotModel addPilot (PilotModel pilot) {
		pilotDb.save(pilot);
		return pilot;
	}
	
	@Override
	public void deletePilot (PilotModel pilot) {
		pilotDb.delete(pilot);
		
	}
	
	@Override
	public void updatePilot (long pilotId, PilotModel newPilot) {
		PilotModel oldPilot = getPilotDetailById(pilotId);
		oldPilot.setName(newPilot.getName());
		oldPilot.setFlyHour(newPilot.getFlyHour());
		
	}
	
	
	
	
}
