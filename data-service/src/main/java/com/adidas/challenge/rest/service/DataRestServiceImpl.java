package com.adidas.challenge.rest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.challenge.domain.TravelDto;
import com.adidas.challenge.service.DataService;

@RestController
public class DataRestServiceImpl implements DataRestService{
	
	@Autowired private DataService dataService;

	@RequestMapping(method = RequestMethod.GET, value = "/travel/{city}")
	public List<TravelDto> findTravelByCity(String city) {
		return dataService.findTravelByCity(city);
	}

	@Override
	public List<TravelDto> findTravelByArrivalTime(String city, LocalDateTime arrivalTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
