package main;

/**
 * @author Travis Kirton
 * 
 * class: ProcessVehicle.java
 * date:  21/01/2018
 * description: Lists vehicles and values in specific orders based on criteria
 * 
 * Extra: Comparator use is based on java 1.8
 */

import java.util.Collections;
import java.util.Comparator;

import main.bean.Response;
import main.bean.Vehicle;

public class ProcessVehicles {

	Response response;
	StringBuilder builder;

	public void process(Response responsePojo) {
		this.response = responsePojo;
		listCarsAscPrice(response);
		listCarsSpecification(response);
		listCarsHighestRatedDesc(response);
		listCarsScoredDesc(response);
	}

	// list all cars in ascending order (based on price)
	public void listCarsAscPrice(Response res) {
		builder = new StringBuilder();
		Collections.sort(res.getVehicles(), Comparator.comparingDouble(Vehicle::getPrice));
		for (int i = 0; i < res.getVehicles().size(); i++) {
			Vehicle v = res.getVehicles().get(i);
			builder.append(i+1 + ". " + v.getName() + " - " + v.getPrice() + "\n");
		}
		System.out.println("*** Listed by Price (Ascending) ***");
		System.out.println(builder);
	}

	// list all car specifications (based on SIPP)
	public void listCarsSpecification(Response res) {
		builder = new StringBuilder();
		for (int i = 0; i < res.getVehicles().size(); i++) {
			Vehicle v = res.getVehicles().get(i);
			initCarSpecs(v);
			builder.append(i+1 + ". " + v.getName() + " - " + v.getSipp() + " - " + v.getCarType() + " - " + v.getDoorsCT() + " - "
					+ v.getTransmission() + " - " + v.getFuel() + " - " + v.getAC() + "\n");
		}
		System.out.println("*** Listed with Specification ***");
		System.out.println(builder);
	}

	// list all cars in descending order (based on rating)
	public void listCarsHighestRatedDesc(Response res) {
		builder = new StringBuilder();
		Collections.sort(res.getVehicles(), Comparator.comparingDouble(Vehicle::getRating).reversed());
		for (int i = 0; i < res.getVehicles().size(); i++) {
			Vehicle v = res.getVehicles().get(i);
			initCarSpecs(v);
			builder.append(
					i+1 + ". " + v.getName() + " - " + v.getCarType() + " - " + v.getSupplier() + " - " + v.getRating() + "\n");
		}
		System.out.println("*** Listed by Rating (Descending) *** ");
		System.out.println(builder);
	}

	// list all cars in descending order (based on score generated)
	public void listCarsScoredDesc(Response res) {
		builder = new StringBuilder();
		Collections.sort(res.getVehicles(), Comparator.comparingDouble(Vehicle::getSumScore).reversed());
		for (int i = 0; i < res.getVehicles().size(); i++) {
			Vehicle v = res.getVehicles().get(i);
			initCarSpecs(v);
			builder.append(i+1 + ". " +v.getName() + " - " + v.getScore() + " - " + v.getRating() + " - "
					+ v.getSumScore() + "\n");
		}
		System.out.println("*** Listed by Score (Descending) ***");
		System.out.println(builder);
	}

	// Initialise specification for a Vehicle
	public void initCarSpecs(Vehicle v) {
		v.setCarType();
		v.setDoorsCT();
		v.setFuel();
		v.setAC();
		v.setTransmission();
		v.setScore();
	}

	public StringBuilder getBuilder() {
		return builder;
	}

}
