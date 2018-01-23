package com.rentalcars.restservice.test;

/**
 * @author Travis Kirton
 * 
 *         class: VehicleControllerTest.java 
 *         date: 21/01/2018
 *         description: Testing VehicleController.java
 */

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rentalcars.restservice.JSONParser;
import com.rentalcars.restservice.ProcessVehicles;
import com.rentalcars.restservice.model.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {

	@Autowired
	private MockMvc mvc;

	JSONParser testParsing;
	Response response;
	ProcessVehicles processVehicles;

	@Before
	public void initObjects() throws Exception{
		processVehicles = new ProcessVehicles();
		testParsing = new JSONParser();

		// valid JSON (just shorter)
		testParsing.readJSON("http://www.rentalcars.com/js/vehicles.json");
		response = testParsing.getPojoResponse();
	}
	
	@Test
	public void testJSONResponse() throws Exception{
		mvc.perform(get("/service/vehicles/listCarsByPriceAsc").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk());
	}

	@Test
	public void getJSONCarsPriceAsc() throws Exception {

		try {
			processVehicles.listCarsAscPrice(response);
			mvc.perform(MockMvcRequestBuilders.get("/service/vehicles/listCarsByPriceAsc")
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0]", is("1. ChevroletSpark - 120.16")))
					.andExpect(jsonPath("$[1]", is("2. Kia Picanto - 136.57")))
					.andExpect(jsonPath("$[2]", is("3. Vauxhall Corsa - 139.93")));
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}
	
	@Test
	public void getJSONCarsSpecification() throws Exception {

		try {
			processVehicles.listCarsAscPrice(response);
			mvc.perform(MockMvcRequestBuilders.get("/service/vehicles/listCarsSpecification")
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0]", is("1. ChevroletSpark - ECMR - Economy - 4 doors - Manual - Petrol - AC")))
					.andExpect(jsonPath("$[1]", is("2. Kia Picanto - MBMN - Mini - 2 doors - Manual - Petrol - no AC")))
					.andExpect(jsonPath("$[2]", is("3. Vauxhall Corsa - ECMR - Economy - 4 doors - Manual - Petrol - AC")));
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}

	}

}
