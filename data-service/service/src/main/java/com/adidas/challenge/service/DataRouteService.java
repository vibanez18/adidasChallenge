package com.adidas.challenge.service;

import java.util.List;

import com.adidas.challenge.domain.RouteDto;

public interface DataRouteService {
	List<RouteDto> findTravelByCityAndDestinyCity(String city, String destinyCity);

}
