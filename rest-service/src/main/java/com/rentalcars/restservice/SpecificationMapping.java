package com.rentalcars.restservice;

import java.util.HashMap;
import java.util.Map;

// Class to map SIPP Letter combination to car spec
public class SpecificationMapping {
	
	Map<String, String> sippL1 = new HashMap<String, String>();
	Map<String, String> sippL2 = new HashMap<String, String>();
	Map<String, String> sippL3 = new HashMap<String, String>();
	Map<String, String> sippL4 = new HashMap<String, String>();
	
	
	// These values could be mapped more efficiently, or call an API
	// to return the correct key -> value pairs
	public SpecificationMapping(){
		sippL1.put("M", "Mini");
		sippL1.put("E", "Economy");
		sippL1.put("C", "Compact");
		sippL1.put("I", "Intermediate");
		sippL1.put("S", "Standard");
		sippL1.put("F", "Full Size"); 
		sippL1.put("P", "Premium");
		sippL1.put("L", "Luxury");
		sippL1.put("X", "Special");
		
		sippL2.put("B", "2 doors");
		sippL2.put("C", "4 doors");
		sippL2.put("D", "5 doors");
		sippL2.put("W", "Estate");
		sippL2.put("T", "Convertible");
		sippL2.put("F", "SUV");
		sippL2.put("P", "Pick up");
		sippL2.put("V", "Passenger Van");
		
		sippL3.put("M", "Manual");
		sippL3.put("A", "Automatic");
		
		sippL4.put("N", "Petrol/no AC");
		sippL4.put("R", "Petrol/AC");
	}
	
	public Map<String, String> getSippL1(){
		return this.sippL1;
	}
	public Map<String, String> getSippL2(){
		return this.sippL2;
	}
	public Map<String, String> getSippL3(){
		return this.sippL3;
	}
	public Map<String, String> getSippL4(){
		return this.sippL4;
	}

}
