package com.adidas.challenge.rest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.challenge.domain.TravelDto;
import com.adidas.challenge.rest.domain.TravelRestDto;
import com.adidas.challenge.service.DataService;

@RequestMapping("/travel")
@RestController
public class DataRestServiceImpl implements DataRestService{
	
	@Autowired private DataService dataService;

	@RequestMapping(method = RequestMethod.GET, value = "/{city}")
	public List<TravelRestDto> findTravelByCity(@PathVariable("city") String city) {
		return copyBeanProperties(dataService.findTravelByCity(city));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{city}/{arrivalTime}")
	public List<TravelRestDto> findTravelByArrivalTime(@PathVariable("city") String city, @PathVariable("arrivalTime") LocalDateTime arrivalTime) {
		return copyBeanProperties(dataService.findTravelByCityAndArrivalTime(city, arrivalTime));
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
