package com.adidas.challenge.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adidas.challenge.domain.Travel;

public interface TravelRepository extends CrudRepository<Travel, Long> {
	List<Travel> findTravelByCity(String city);
	List<Travel> findTravelByCityAndArrivalTime(String city, LocalDateTime arrivalTime);
}
