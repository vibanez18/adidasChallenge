package com.adidas.challenge.rest;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.adidas.challenge.domain.TravelDto;
import com.adidas.challenge.rest.service.DataRestService;

@SpringBootTest
@EnableFeignClients
public class DataRestServiceTest {
	
	@Autowired private DataRestService dataRestService;
	
	@Test
	public void findTravelByValenciaCityTest() {
		List<TravelDto> travels = dataRestService.findTravelByCity("Valencia");
		
		assertFalse(travels.isEmpty());
	}

}
