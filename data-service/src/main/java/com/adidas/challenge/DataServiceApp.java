package com.adidas.challenge;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.challenge.domain.Travel;
import com.adidas.challenge.repository.TravelRepository;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class DataServiceApp {
	
	@Autowired TravelRepository travelRepository;
	
	//TODO: Remove it
	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(DataServiceApp.class, args);
	}
	
	@PostConstruct
	public void init() {
		List<Travel> list = new ArrayList<>();
		
		list.add(new Travel("Valencia", "Madrid", LocalDateTime.of(2018, Month.JUNE, 18, 18, 0), LocalDateTime.of(2018, Month.JUNE, 18, 19, 45)));
		list.add(new Travel("Valencia", "Barcelona", LocalDateTime.of(2018, Month.JUNE, 18, 18, 0), LocalDateTime.of(2018, Month.JUNE, 18, 21, 30)));
		list.add(new Travel("Valencia", "Zaragoza", LocalDateTime.of(2018, Month.JUNE, 18, 17, 0), LocalDateTime.of(2018, Month.JUNE, 18, 19, 15)));
		
		travelRepository.saveAll(list);
	}
}
