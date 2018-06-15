package com.adidas.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidas.challenge.domain.Route;
import com.adidas.challenge.domain.RouteDto;
import com.adidas.challenge.repository.RouteRepository;

@Service
public class DataRouteServiceImpl implements DataRouteService{
	
	@Autowired private RouteRepository routeRepository;

	public List<RouteDto> findTravelByCityAndDestinyCity(String city, String destinyCity) {
		
		List<Route> routes = routeRepository.findTravelByCityAndDestinyCity(city, destinyCity);
		
		return copyPropertiesBean(routes);
	}
	
	private List<RouteDto> copyPropertiesBean(List<Route> routes) {
		List<RouteDto> routesDto = new ArrayList<>();
		
		for (Route route : routes) {
			RouteDto routeDto = new RouteDto();
			BeanUtils.copyProperties(route, routeDto);
			routesDto.add(routeDto);
		}
		return routesDto;
	}

}
