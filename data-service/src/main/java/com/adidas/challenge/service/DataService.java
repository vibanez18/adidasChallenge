package com.adidas.challenge.service;

import java.time.LocalDateTime;
import java.util.List;

import com.adidas.challenge.domain.TravelDto;

public interface DataService {
	
	List<TravelDto> findTravelByCity(String city);
	List<TravelDto> findTravelByCityAndArrivalTime(String city, LocalDateTime arrivalTime);

}
