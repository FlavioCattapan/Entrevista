package com.teste.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class VehicleJsonWrapper {
	
	
	private List<Vehicle> results;

	public List<Vehicle> getResults() {
		return results;
	}

	public void setResults(List<Vehicle> results) {
		this.results = results;
	}
	
	

}
