package com.adidas.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.challenge.rest.domain.TravelRestDto;
import com.adidas.challenge.rest.service.DataRestService;

@RequestMapping("/calculate")
@RestController
public class BusinessLogicController {

	@Autowired private DataRestService dataFeignClient;
	
	@RequestMapping(method = RequestMethod.GET, value = "/bytime/{originCity}/{destinationCity}")
	public List<TravelRestDto> calculateTravelByTime(@PathVariable String originCity, @PathVariable String destinationCity){
		List<TravelRestDto> travelsSinceOrigin = dataFeignClient.findTravelByCity(originCity);
		
		
		
		return null;
	}
	
}