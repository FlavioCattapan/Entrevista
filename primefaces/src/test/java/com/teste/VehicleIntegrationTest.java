package com.teste;

import static org.junit.Assert.*;
import org.junit.Test;

import com.teste.integration.VehicleIntegration;
import com.teste.integration.impl.VehicleIntegrationImpl;
import com.teste.model.VehicleJsonWrapper;

public class VehicleIntegrationTest {

	//@Test
	public void test() {
		VehicleIntegration jerseyClientGet = new VehicleIntegrationImpl();
		VehicleJsonWrapper vehicleJsonWrapper = jerseyClientGet.run();		
		assertEquals(vehicleJsonWrapper.getResults().size(), 10);
		
	}

}
