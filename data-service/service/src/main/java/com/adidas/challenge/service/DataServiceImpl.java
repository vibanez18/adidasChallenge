package com.adidas.challenge.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidas.challenge.domain.Travel;
import com.adidas.challenge.domain.TravelDto;
import com.adidas.challenge.repository.TravelRepository;

@Service
public class DataServiceImpl implements DataService {
	
	private @Autowired TravelRepository travelRepository;

	public List<TravelDto> findTravelByCity(String city) {
		
		List<Travel> travels = travelRepository.findTravelByCity(city);
		return copyPropertiesBean(travels);
	}

	public List<TravelDto> findTravelByCityAndArrivalTime(String city, LocalDateTime arrivalTime) {
		List<Travel> travels = travelRepository.findTravelByCityAndArrivalTime(city, arrivalTime);
		return copyPropertiesBean(travels);
	}

	public List<TravelDto> findTravelByCityAndDestinyCity(String city, String destinyCity) {
		List<Travel> travels = travelRepository.findTravelByCityAndDestinyCity(city, destinyCity);
		return copyPropertiesBean(travels);
	}

	private List<TravelDto> copyPropertiesBean(List<Travel> travels) {
		List<TravelDto> travelsDto = new ArrayList<>();
		
		for (Travel travel : travels) {
			TravelDto travelDto = new TravelDto();
			BeanUtils.copyProperties(travel, travelDto);
			travelsDto.add(travelDto);
		}
		return travelsDto;
	}

}
