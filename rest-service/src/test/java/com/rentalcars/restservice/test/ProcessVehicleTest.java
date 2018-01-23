package com.rentalcars.restservice.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rentalcars.restservice.JSONParser;
import com.rentalcars.restservice.ProcessVehicles;
import com.rentalcars.restservice.model.Response;


/**
 * @author Travis Kirton
 * 
 *         class: ProcessVehicleTest.java date: 21/01/2018 description: Tests
 *         ProcessVehicle.java
 */

public class ProcessVehicleTest {

	JSONParser testParsing;
	ProcessVehicles processVehicles;
	Response response;

	@Before
	public void initialiseObjects() throws Exception {
		processVehicles = new ProcessVehicles();
		testParsing = new JSONParser();

		// valid JSON (just shorter)
		testParsing.readJSON("https://api.myjson.com/bins/yxkld");
		response = testParsing.getPojoResponse();
	}

	@Test
	public void testCarsAscendingPrice() {
		processVehicles.listCarsAscPrice(response);
		String expected[] = {"1. Ford Focus - 157.85","2. VW Passat Estate - 469.37","3. Ford Galaxy - 706.89"};
		Assert.assertTrue(processVehicles.getResuls().get(0).equals(expected[0]));
		Assert.assertTrue(processVehicles.getResuls().get(1).equals(expected[1]));
		Assert.assertTrue(processVehicles.getResuls().get(2).equals(expected[2]));
		
	}

	@Test
	public void testCarsSpecification() {
		processVehicles.listCarsSpecification(response);
		String expected[] = {"1. Ford Focus - CDMR - Compact - 5 doors - Manual - Petrol - AC","2. Ford Galaxy - FVAR - Full Size - Passenger Van - Automatic - Petrol - AC","3. VW Passat Estate - IWMR - Intermediate - Estate - Manual - Petrol - AC"};
		Assert.assertTrue(processVehicles.getResuls().get(0).equals(expected[0]));
		Assert.assertTrue(processVehicles.getResuls().get(1).equals(expected[1]));
		Assert.assertTrue(processVehicles.getResuls().get(2).equals(expected[2]));
	}

	@Test
	public void testCarsHightestRatedDesc() {
		processVehicles.listCarsHighestRatedDesc(response);
		String expected[] = {"1. Ford Focus - Compact - Hertz - 8.9","2. Ford Galaxy - Full Size - Hertz - 8.9","3. VW Passat Estate - Intermediate - Hertz - 8.9"};
		Assert.assertTrue(processVehicles.getResuls().get(0).equals(expected[0]));
		Assert.assertTrue(processVehicles.getResuls().get(1).equals(expected[1]));
		Assert.assertTrue(processVehicles.getResuls().get(2).equals(expected[2]));
		
	}

	@Test
	public void testCarsScoredDesc() {
		processVehicles.listCarsScoredDesc(response);
		String expected[] = {"1. Ford Focus - 1 - 8.9 - 9.9","2. Ford Galaxy - 5 - 8.9 - 13.9","3. VW Passat Estate - 1 - 8.9 - 9.9"};
		Assert.assertTrue(processVehicles.getResuls().get(0).equals(expected[0]));
		Assert.assertTrue(processVehicles.getResuls().get(1).equals(expected[1]));
		Assert.assertTrue(processVehicles.getResuls().get(2).equals(expected[2]));
	}

}
