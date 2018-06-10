package com.adidas.challenge.rest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.challenge.domain.TravelDto;
import com.adidas.challenge.service.DataService;

@RequestMapping("/travel")
@RestController
public class DataRestServiceImpl implements DataRestService{
	
	@Autowired private DataService dataService;

	@RequestMapping(method = RequestMethod.GET, value = "/{city}")
	public List<TravelDto> findTravelByCity(@PathVariable("city") String city) {
		return dataService.findTravelByCity(city);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{city}/{arrivalTime}")
	public List<TravelDto> findTravelByArrivalTime(@PathVariable("city") String city, @PathVariable("arrivalTime") LocalDateTime arrivalTime) {
		return dataService.findTravelByCityAndArrivalTime(city, arrivalTime);
	}

}
