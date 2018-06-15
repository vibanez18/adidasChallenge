package com.adidas.challenge.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.challenge.rest.domain.RouteRestDto;
import com.adidas.challenge.rest.domain.TravelRestDto;
import com.adidas.challenge.rest.service.DataRestService;

@RequestMapping("/calculate")
@RestController
public class BusinessLogicController {

	@Autowired private DataRestService dataFeignClient;
	
	@RequestMapping(method = RequestMethod.GET, value = "/bytime")
	public List<CalculateResponse> calculateTravelByTime(@RequestParam String city, @RequestParam String destinyCity){
		
		//TODO: Sort by time
		
		return calculateAllTravels(city, destinyCity);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/byconnection")
	public List<CalculateResponse> calculateTravelByConnection(@RequestParam String city, @RequestParam String destinyCity){
		
		//TODO: Sort by connection
		
		return calculateAllTravels(city, destinyCity);
	}

	private List<CalculateResponse> calculateAllTravels(String city, String destinyCity) {
		List<CalculateResponse> calculateResponseList = new ArrayList<>();
 		List<TravelRestDto> travels = dataFeignClient.getTravel(city, destinyCity);
		
 		for (TravelRestDto travelRestDto : travels) {
 			if(travelRestDto.isDirect()) {
 				//Is Direct
 				CalculateResponse calculateResponse = new CalculateResponse();
 				BeanUtils.copyProperties(travelRestDto, calculateResponse);
 				calculateResponse.setConnection("Direct");
 				
 				Duration duration = Duration.between(travelRestDto.getArrivalTime(), travelRestDto.getDepartureTime());
 				calculateResponse.setDuration(duration);
 				
 				calculateResponseList.add(calculateResponse);
 			}
 			else {
 				// Need Connection
 				List<RouteRestDto> routes = dataFeignClient.getRoute(city, destinyCity);
 				 for (RouteRestDto routeRestDto : routes) {
 					CalculateResponse calculateResponseRoutes = new CalculateResponse();
 					
 					calculateResponseRoutes.setCity(routeRestDto.getCity());
 					calculateResponseRoutes.setDestinyCity(routeRestDto.getDestinyCity());
 					
 					// Get departure time by First travel
 					LocalDateTime departureTime = travelRestDto.getDepartureTime();
 					
 					List <TravelRestDto>travelsList = routeRestDto.getTravels();
 					//get first travel
 					calculateResponseRoutes.setConnection(travelsList.get(0).getCity());
 					
 					//get last travel
 					LocalDateTime arrivalTime = travelsList.get(travelsList.size() - 1).getArrivalTime();
 					
 					Duration duration = Duration.between(arrivalTime, departureTime);
 					calculateResponseRoutes.setDuration(duration);
 					
 					calculateResponseList.add(calculateResponseRoutes);
				}
 				 break;
 			}
		}
 		
		return calculateResponseList;
	}
	
}
