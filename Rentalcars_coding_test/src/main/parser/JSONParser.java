package main.parser;

/**
 * @author Travis Kirton
 * 
 *         class: JSONParser.java 
 *         date: 23/01/2018 
 *         description: reading initial JSON
 */

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

import main.bean.Response;

public class JSONParser {

	private Response responsePojo;

	public void readJSON(String url)
			throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		responsePojo = mapper.readValue(new URL(url), Response.class);

	}

	public Response getPojoResponse() {
		return responsePojo;
	}

}
