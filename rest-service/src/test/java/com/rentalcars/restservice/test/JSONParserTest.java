package com.rentalcars.restservice.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rentalcars.restservice.JSONParser;


/**
 * @author Travis Kirton
 * 
 *         class: JSONParserTest.java 
 *         date: 21/01/2018 
 *         description: Tests JSONParser.java
 */

public class JSONParserTest {

	JSONParser testParsing;

	@Before
	public void initObjects() {
		testParsing = new JSONParser();
	}

	@Test
	public void populateResponseObjectSuccess() {
		// test that when given a correct JSON
		// an exception isn't thrown
		try {
			testParsing.readJSON("http://www.rentalcars.com/js/vehicles.json");
			assertEquals(31, testParsing.getPojoResponse().getVehicles().size());
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

	@Test
	public void incorrectJSONURL() {
		// test that when given an incorrect JSON
		// an exception is thrown
		try {
			testParsing.readJSON("http://www.rentalcars.com/js");
			fail("Expected Exception not thrown");
		}
		// expect exceptions to be caught
		catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

	@Test
	public void incorrectlyFormattedJSON() {
		// test that when given an incorrectly formatted JSON
		// an exception is thrown
		try {
			testParsing.readJSON("https://api.myjson.com/bins/k3nwx");
			fail("Expected Exception not thrown");
		}
		// expect exceptions to be caught
		catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

}
