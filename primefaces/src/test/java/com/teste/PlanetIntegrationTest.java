package com.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.teste.integration.PlanetIntegration;
import com.teste.integration.impl.PlanetIntegrationImpl;
import com.teste.model.PlanetJsonWrapper;

public class PlanetIntegrationTest {

	@Test
	public void test() {
		PlanetIntegration jerseyClientGet = new PlanetIntegrationImpl();
		PlanetJsonWrapper planetJsonWrapper = jerseyClientGet.run();		
		assertEquals(planetJsonWrapper.getResults().size(), 10);
	  
	}

}
