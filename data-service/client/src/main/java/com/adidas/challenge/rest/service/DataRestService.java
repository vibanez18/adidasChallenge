package com.adidas.challenge.rest.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adidas.challenge.rest.domain.RouteRestDto;
import com.adidas.challenge.rest.domain.TravelRestDto;

@FeignClient("data-service")
public interface DataRestService {
	
	//TODO: Remove
	@RequestMapping(method = RequestMethod.GET, value = "/api/travel/{city}")
	List<TravelRestDto> findTravelByCity(@PathVariable("city") String city);
	
	//TODO: Remove
//	@RequestMapping(method = RequestMethod.GET, value = "/travel/{city}/{time}")
//	List<TravelRestDto> findTravelByArrivalTime(@PathVariable("city") String city,@PathVariable("time") LocalDateTime arrivalTime);
	
	//ok
	@RequestMapping(method = RequestMethod.GET, value = "/api/travel")
	List<TravelRestDto> getTravel(@RequestParam("city") String city, @RequestParam("destinyCity") String destinyCity);
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/travel/route")
	List<RouteRestDto> getRoute(@RequestParam("city") String city, @RequestParam("destinyCity") String destinyCity);
}
