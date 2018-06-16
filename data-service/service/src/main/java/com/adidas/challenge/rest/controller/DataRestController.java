package com.adidas.challenge.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.challenge.domain.RouteDto;
import com.adidas.challenge.domain.TravelDto;
import com.adidas.challenge.rest.domain.RouteRestDto;
import com.adidas.challenge.rest.domain.TravelRestDto;
import com.adidas.challenge.rest.service.DataRestService;
import com.adidas.challenge.service.DataRouteService;
import com.adidas.challenge.service.DataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api/travels")
@Api(value = "travels", produces = "application/json")
@RestController
public class DataRestController implements DataRestService{
	
	@Autowired private DataService dataService;
	@Autowired private DataRouteService dataRouteService;

	@RequestMapping(method = RequestMethod.GET, value = "/{city}")
	@ApiOperation(value = "Get all Travels by city", notes = "Get all Travels by city")
	@ApiResponses({
        @ApiResponse(code = 200, message = "Return all travels by city")
	})
	public List<TravelRestDto> findTravelByCity(@PathVariable("city") String city) {
		return copyBeanProperties(dataService.findTravelByCity(city));
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/{city}/{arrivalTime}")
//	public List<TravelRestDto> findTravelByArrivalTime(@PathVariable("city") String city, @PathVariable("arrivalTime") LocalDateTime arrivalTime) {
//		return copyBeanProperties(dataService.findTravelByCityAndArrivalTime(city, arrivalTime));
//	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get all Travels by city and destiny city", notes = "Get all Travels by city and destiny city")
	@ApiResponses({
        @ApiResponse(code = 200, message = "Return all travels by city and destiny city")
	})
	public List<TravelRestDto> getTravel(@RequestParam("city") String city, @RequestParam("destinyCity") String destinyCity) {
		return copyBeanProperties(dataService.findTravelByCityAndDestinyCity(city, destinyCity));
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/route")
	@ApiOperation(value = "Get all Routes by city and destiny city", notes = "Get all Routes by city and destiny city")
	@ApiResponses({
        @ApiResponse(code = 200, message = "Return all routes by city and destiny city")
	})
	public List<RouteRestDto> getRoute(String city, String destinyCity) {
		
		return copyRouteRestDtoProperties(dataRouteService.findTravelByCityAndDestinyCity(city, destinyCity));
	}

	private List<RouteRestDto> copyRouteRestDtoProperties(List<RouteDto> routesDto) {
		List<RouteRestDto> routesRestDto = new ArrayList<>();
		
		for (RouteDto routeDto : routesDto) {
			RouteRestDto routeRestDto = new RouteRestDto();
			BeanUtils.copyProperties(routeDto, routeRestDto);
			routesRestDto.add(routeRestDto);
		}
		
		return routesRestDto;
	}
	
	private List<TravelRestDto> copyBeanProperties(List<TravelDto> travels){
		
		List<TravelRestDto> travelsRestDto = new ArrayList<>();
		
		for (TravelDto travelDto : travels) {
			TravelRestDto travelRestDto = new TravelRestDto();
			BeanUtils.copyProperties(travelDto, travelRestDto);
			travelsRestDto.add(travelRestDto);
		}
		
		return travelsRestDto;
	}

}
