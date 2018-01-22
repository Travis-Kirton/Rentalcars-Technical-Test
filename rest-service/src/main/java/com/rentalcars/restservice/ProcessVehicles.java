package com.rentalcars.restservice;

import java.util.ArrayList;

/**
 * @author Travis Kirton
 * 
 * class: ProcessVehicle.java
 * date:  21/01/2018
 * description: Lists vehicles and values in specific orders based on criteria
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.rentalcars.restservice.model.Response;
import com.rentalcars.restservice.model.Vehicle;


public class ProcessVehicles {
	
	private Response response;
	private List<String> results;
	
	public void process(Response responsPojo){
		this.response = responsPojo;
		
		listCarsAscPrice(response);
		listCarsSpecification(response);
		listCarsHighestRatedDesc(response);
		listCarsScoredDesc(response);
	}
	
	// list all cars in ascending order (based on price)
	public List<String> listCarsAscPrice(Response res){
		results = new ArrayList<String>();
		Collections.sort(res.getVehicles(), Comparator.comparingDouble(Vehicle ::getPrice));
		for(int i = 0; i < res.getVehicles().size(); i++){
			Vehicle v = res.getVehicles().get(i);
			initCarSpecs(v);
			results.add(i+1+". " + v.getName() + " - " + v.getPrice());
		}
		return results;
	}
	
	// list all car specifications (based on SIPP)
	public List<String> listCarsSpecification(Response res){
		results = new ArrayList<String>();
		for(int i = 0; i < res.getVehicles().size(); i++){
			Vehicle v = res.getVehicles().get(i);
			initCarSpecs(v);
			results.add(i+1+". " + v.getName() + " - " + v.getSipp() + " - " + v.getCarType() + " - " + v.getDoorsCT() + " - " + v.getTransmission() + " - " + v.getFuel() + " - " + v.getAC());
		}
		return results;
	}
	
	// list all cars in descending order (based on rating)
	public List<String> listCarsHighestRatedDesc(Response res){
		results = new ArrayList<String>();
		Collections.sort(res.getVehicles(), Comparator.comparingDouble(Vehicle ::getRating).reversed());
		for(int i = 0; i < res.getVehicles().size(); i++){
			Vehicle v = res.getVehicles().get(i);
			results.add(i+1+". " + v.getName() + " - " + v.getCarType() + " - " + v.getSupplier() + " -  "+ v.getRating());
		}
		return results;
	}
	
	// list all cars in descending order (based on score generated)
	public List<String> listCarsScoredDesc(Response res){
		results = new ArrayList<String>();
		Collections.sort(res.getVehicles(), Comparator.comparingDouble(Vehicle :: getSumScore).reversed());
		for(int i = 0; i < res.getVehicles().size(); i++){
			Vehicle v = res.getVehicles().get(i);
			initCarSpecs(v);
			results.add(i+1+". " + v.getName() + " - " + v.getScore() + " - " + v.getRating() +  " - " + v.getSumScore());
		}
		return results;
	}
	
	//Initialise specification for a Vehicle
	public void initCarSpecs(Vehicle v){
		v.setCarType();
		v.setDoorsCT();
		v.setFuel();
		v.setAC();
		v.setTransmission();
		v.setScore();
	}
	
	public List<String> getResuls(){
		return results;
	}

}