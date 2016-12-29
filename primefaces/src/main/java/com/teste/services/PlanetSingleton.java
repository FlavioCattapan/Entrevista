package com.teste.services;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import com.teste.integration.PlanetIntegration;
import com.teste.integration.impl.PlanetIntegrationImpl;
import com.teste.model.PlanetJsonWrapper;

@Singleton
public class PlanetSingleton {

	private PlanetJsonWrapper planetJsonWrapper;

	@PostConstruct
	void initialize() {
		PlanetIntegration jerseyClientGet = new PlanetIntegrationImpl();
		planetJsonWrapper = jerseyClientGet.run();

	}

	public PlanetJsonWrapper getPlanetJsonWrapper() {
		return planetJsonWrapper;
	}

	public void setPlanetJsonWrapper(PlanetJsonWrapper planetJsonWrapper) {
		this.planetJsonWrapper = planetJsonWrapper;
	}

}
