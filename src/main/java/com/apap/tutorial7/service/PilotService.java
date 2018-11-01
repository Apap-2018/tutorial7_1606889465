package com.apap.tutorial7.service;

import com.apap.tutorial7.model.PilotModel;

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	PilotModel addPilot(PilotModel pilot);
	PilotModel getPilotDetailById(Long id);
	void deletePilot(PilotModel pilot);
	void updatePilot(long pilotId, PilotModel newPilot);

}
