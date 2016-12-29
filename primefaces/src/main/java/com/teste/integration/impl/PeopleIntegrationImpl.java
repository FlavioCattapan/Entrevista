package com.teste.integration.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.teste.constants.StarConstants;
import com.teste.integration.PeopleIntegration;
import com.teste.model.PeopleJsonWrapper;

	

public class PeopleIntegrationImpl implements PeopleIntegration {

	/* (non-Javadoc)
	 * @see com.teste.integration.VehicleJsonIntegrarion#run()
	 */
	@Override
	public PeopleJsonWrapper run() {

		Client c = Client.create();
		WebResource wr = c.resource(StarConstants.PEOPLE_URL);
		ClientResponse resp = wr.accept("application/json").header("user-agent", "").get(ClientResponse.class);
		if (resp.getStatus() != 200) {
			throw new RuntimeException("Failed http error code :" + resp.getStatus());			
		}
		String output = resp.getEntity(String.class);			
		ObjectMapper mapper = new ObjectMapper();		
		PeopleJsonWrapper peopleJsonWrapper = null;
		try {			
			peopleJsonWrapper = mapper.readValue(output,  PeopleJsonWrapper.class);						
		} catch (JsonGenerationException e) {
			throw new RuntimeException("Failed  :" + e.getMessage());
		} catch (JsonMappingException e) {
			throw new RuntimeException("Failed  :" + e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException("Failed  :" + e.getMessage());
		}
			
		return peopleJsonWrapper;
		
	}

}
