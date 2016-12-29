package com.teste;

import static org.junit.Assert.*;
import org.junit.Test;

import com.teste.integration.PeopleIntegration;
import com.teste.integration.VehicleIntegration;
import com.teste.integration.impl.PeopleIntegrationImpl;
import com.teste.integration.impl.VehicleIntegrationImpl;
import com.teste.model.PeopleJsonWrapper;
import com.teste.model.VehicleJsonWrapper;

public class PeopleIntegrationTest {

	@Test
	public void test() {
		PeopleIntegration jerseyClientGet = new PeopleIntegrationImpl();
		PeopleJsonWrapper jeopleJsonWrapper = jerseyClientGet.run();		
		assertEquals(jeopleJsonWrapper.getResults().size(), 10);
	  
	}

}
