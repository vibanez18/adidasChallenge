package com.adidas.challenge.rest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adidas.challenge.domain.TravelDto;

@FeignClient("data-service")
public interface DataRestService {
	
	@RequestMapping(method = RequestMethod.GET, value = "/travel/{city}")
	List<TravelDto> findTravelByCity(@PathVariable("city") String city);
	
	@RequestMapping(method = RequestMethod.GET, value = "/travel/{city}/{time}")
	List<TravelDto> findTravelByArrivalTime(@PathVariable("city") String city,@PathVariable("time") LocalDateTime arrivalTime);
}
