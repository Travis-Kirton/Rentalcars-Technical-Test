package main.bean;

/**
 * @author Travis Kirton
 * 
 * class: Vehicle.java
 * date:  21/01/2018
 * description: Object to store Vehicle Details
 */

import main.SpecificationMapping;

//A simple POJO for holding the car details
public class Vehicle {
	
	SpecificationMapping specMap = new SpecificationMapping();

	private double price;
	private double rating;
	
	private String sipp;
	private String name;
	private String supplier;
	
	private String carType;
	private String doorsCT;
	private String transmission;
	private String fuel;
	private String AC;
	
	private int score;

	public Vehicle() {

	}

	public Vehicle(String sipp, String name, double price, String supplier, double rating) {
		this.sipp = sipp;
		this.name = name;
		this.price = price;
		this.supplier = supplier;
		this.rating = rating;
	}

	public String getSipp() {
		return sipp;
	}

	public void setSipp(String sipp) {
		this.sipp = sipp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType() {
		this.carType = specMap.getSippL1().get(""+this.sipp.charAt(0));
	}

	public String getDoorsCT() {
		return doorsCT;
	}

	public void setDoorsCT() {
		this.doorsCT = specMap.getSippL2().get(""+this.sipp.charAt(1));
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission() {
		this.transmission = specMap.getSippL3().get(""+this.sipp.charAt(2));
	
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel() {
		String[] fuelAC = specMap.getSippL4().get(""+this.sipp.charAt(3)).split("/");
		this.fuel = fuelAC[0];	
	}
	
	public String getAC() {
		return AC;
	}

	public void setAC() {
		String[] fuelAC = specMap.getSippL4().get(""+this.sipp.charAt(3)).split("/");
		this.AC = fuelAC[1];
	}
	
	public void setScore(){
		if(this.transmission == "Manual") this.score += 1;
		if(this.transmission == "Automatic") this.score +=5;
		if(this.AC == "AC") this.score += 2;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public double getSumScore(){
		return getRating() + getScore();
	}
	
	
	
	

}
