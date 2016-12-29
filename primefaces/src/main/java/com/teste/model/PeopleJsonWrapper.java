package com.teste.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PeopleJsonWrapper {
	
	
	private List<People> results;

	public List<People> getResults() {
		return results;
	}

	public void setResults(List<People> results) {
		this.results = results;
	}
	
	

}
