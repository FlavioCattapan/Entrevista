package com.teste.services;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import com.teste.integration.PeopleIntegration;
import com.teste.integration.impl.PeopleIntegrationImpl;
import com.teste.model.PeopleJsonWrapper;

@Singleton
public class PeopleSingleton {

	private PeopleJsonWrapper peopleJsonWrapper;

	@PostConstruct
	void initialize() {
		PeopleIntegration jerseyClientGet = new PeopleIntegrationImpl();
		peopleJsonWrapper = jerseyClientGet.run();

	}

	public PeopleJsonWrapper getPeopleJsonWrapper() {
		return peopleJsonWrapper;
	}

	public void setPeopleJsonWrapper(PeopleJsonWrapper peopleJsonWrapper) {
		this.peopleJsonWrapper = peopleJsonWrapper;
	}
	
	

	
}
