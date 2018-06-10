package com.adidas.challenge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.adidas.challenge.domain.TravelDto;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DataServiceTest {
	
	@Autowired private DataService dataService;
	
	@Test
	public void findTravelByCityTest() {
		findTravelByCity("Valencia");
		findTravelByCity("Madrid");
		findTravelByCity("Zaragoza");
	}

	@Test
	public void findTravelByArrivalTimeTest() {
		findTravelByCityAndArrivalTime("Valencia", LocalDateTime.of(2018, Month.JUNE, 18, 11, 45));
		findTravelByCityAndArrivalTime("Zaragoza", LocalDateTime.of(2018, Month.JUNE, 18, 13, 15));
		findTravelByCityAndArrivalTime("Madrid", LocalDateTime.of(2018, Month.JUNE, 18, 16, 30));
	}

	private void findTravelByCityAndArrivalTime(String city, LocalDateTime arrivalTime) {
		List<TravelDto> travels = dataService.findTravelByCityAndArrivalTime(city, arrivalTime);
		assertFalse(travels.isEmpty());
		
		for (TravelDto travelDto : travels) {
			assertEquals(city, travelDto.getCity());
			assertEquals(arrivalTime.getDayOfMonth(), travelDto.getArrivalTime().getDayOfMonth());
			assertEquals(arrivalTime.getHour(), travelDto.getArrivalTime().getHour());
			assertEquals(arrivalTime.getMinute(), travelDto.getArrivalTime().getMinute());
		}
	}
	
	private void findTravelByCity(String city) {
		List<TravelDto> travels = dataService.findTravelByCity(city);
		
		assertFalse(travels.isEmpty());
		
		for (TravelDto travelDto : travels) {
			assertEquals(city, travelDto.getCity());
		}
	}

}
