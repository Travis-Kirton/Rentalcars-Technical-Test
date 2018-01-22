package com.rentalcars.restservice.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalcars.restservice.JSONParser;
import com.rentalcars.restservice.ProcessVehicles;
import com.rentalcars.restservice.model.Response;


@RestController
@RequestMapping(VehicleController.RENTALCARS_BASE_URI)
public class VehicleController {
	
	
	
	public static final String RENTALCARS_BASE_URI = "service/vehicles";
	
	Response response;
	JSONParser jsonParser = new JSONParser();
	ProcessVehicles processVehicles = new ProcessVehicles();
	
	@PostConstruct
	public void init(){
		try {
			response = jsonParser.readJSON("http://www.rentalcars.com/js/vehicles.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
		processVehicles.process(response);
	}
	
	@RequestMapping("/listCarsByPriceAsc")
	public List<String> listCarsAscPrice(){
		return processVehicles.listCarsAscPrice(this.response);
	}
	
	@RequestMapping("/listCarsSpecification")
	public List<String> listCarsSpecification(){
		return processVehicles.listCarsSpecification(this.response);
	}
	
	@RequestMapping("/listCarsHighestRatedDesc")
	public List<String> listCarsHighestRatedDesc(){
		return processVehicles.listCarsHighestRatedDesc(this.response);
	}
	
	@RequestMapping("/listCarsScoredDesc")
	public List<String> listCarsScoredDesc(){
		return processVehicles.listCarsScoredDesc(this.response);
	}
	
	

}
