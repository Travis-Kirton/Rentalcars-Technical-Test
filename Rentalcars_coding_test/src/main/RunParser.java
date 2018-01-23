package main;

/**
 * @author Travis Kirton
 * 
 *         class: RunParser.java 
 *         date: 23/01/2018 
 *         description: Main method to run app
 *        
 */

import main.parser.JSONParser;

public class RunParser {

	public static void main(String args[]) {
		JSONParser jsonParser = new JSONParser();
		ProcessVehicles processVehicles = new ProcessVehicles();

		try {
			jsonParser.readJSON("http://www.rentalcars.com/js/vehicles.json");
			processVehicles.process(jsonParser.getPojoResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
