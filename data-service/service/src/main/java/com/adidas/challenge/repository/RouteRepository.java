package com.adidas.challenge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adidas.challenge.domain.Route;

public interface RouteRepository extends CrudRepository<Route, Long> {
	
	List<Route> findTravelByCityAndDestinyCity(String city, String destinyCity);

}
