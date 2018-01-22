package com.rentalcars.restservice;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author Travis Kirton
 * 
 * class: JSONParser.java
 * date:  21/01/2018
 * description: Reads a specific JSON from URL and stores results
 */

import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentalcars.restservice.model.Response;


public class JSONParser {
	
	private Response responsePojo;
	
	public Response readJSON(String url) throws JsonParseException, JsonMappingException, MalformedURLException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE,  true);
		responsePojo = mapper.readValue(new URL(url), Response.class);
		
		return responsePojo;
	}
	
	public Response getPojoResponse() {
		return responsePojo;
	}
	

}