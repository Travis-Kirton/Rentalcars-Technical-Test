package main.bean;

/**
 * @author Travis Kirton
 * 
 * class: Respnse.java
 * date:  21/01/2018
 * description: Uses Jackson libraries to specify and store JSON
 */

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Search")
public class Response {
	private final List<Vehicle> vehicles;
	
	@JsonCreator
    public Response(@JsonProperty("VehicleList") final List<Vehicle> authors) {
        this.vehicles = authors;
    }
	
	@JsonProperty("VehicleList")
	public List<Vehicle> getVehicles(){
		return vehicles;
	}

}
