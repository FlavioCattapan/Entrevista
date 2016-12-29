package com.teste.services;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import com.teste.integration.PlanetIntegration;
import com.teste.integration.VehicleIntegration;
import com.teste.integration.impl.PlanetIntegrationImpl;
import com.teste.integration.impl.VehicleIntegrationImpl;
import com.teste.model.PlanetJsonWrapper;
import com.teste.model.VehicleJsonWrapper;

@Singleton
public class VehicleSingleton {

	private VehicleJsonWrapper vehicleJsonWrapper;

	@PostConstruct
	void initialize() {
		VehicleIntegration jerseyClientGet = new VehicleIntegrationImpl();
		vehicleJsonWrapper = jerseyClientGet.run();	

	}

	public VehicleJsonWrapper getVehicleJsonWrapper() {
		return vehicleJsonWrapper;
	}

	public void setVehicleJsonWrapper(VehicleJsonWrapper vehicleJsonWrapper) {
		this.vehicleJsonWrapper = vehicleJsonWrapper;
	}

	

}
