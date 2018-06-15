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
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.adidas.challenge.domain.Route;
import com.adidas.challenge.domain.Travel;
import com.adidas.challenge.repository.RouteRepository;
import com.adidas.challenge.repository.TravelRepository;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients (basePackages="com.adidas.challenge.rest.service")
public class DataServiceApp {
	
	@Autowired TravelRepository travelRepository;
	@Autowired RouteRepository routeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DataServiceApp.class, args);
	}
	
	@PostConstruct
	public void init() {
		List<Travel> travels0 = new ArrayList<>();
		List<Travel> travels1 = new ArrayList<>();
		List<Travel> travels2 = new ArrayList<>();
		List<Travel> travels3 = new ArrayList<>();
		List<Travel> travels4 = new ArrayList<>();
		List<Travel> travels5 = new ArrayList<>();
		Route route1;
		Route route2;
		Route route3;
		Route route4;
		Route route5;
		
		// direct travel
		travels0.add(new Travel("Zaragoza", "Berlin", LocalDateTime.of(2018, Month.JUNE, 18, 8, 0), LocalDateTime.of(2018, Month.JUNE, 18, 10, 00), true));
		travels0.add(new Travel("Zaragoza", "London", LocalDateTime.of(2018, Month.JUNE, 18, 9, 0), LocalDateTime.of(2018, Month.JUNE, 18, 11, 30), true));
		travels0.add(new Travel("Zaragoza", "Milan", LocalDateTime.of(2018, Month.JUNE, 18, 10, 0), LocalDateTime.of(2018, Month.JUNE, 18, 13, 00), true));
		travels0.add(new Travel("London", "Milan", LocalDateTime.of(2018, Month.JUNE, 18, 15, 0), LocalDateTime.of(2018, Month.JUNE, 18, 17, 00), true));
		travels0.add(new Travel("London", "Berlin", LocalDateTime.of(2018, Month.JUNE, 18, 16, 0), LocalDateTime.of(2018, Month.JUNE, 18, 17, 00), true));
		travels0.add(new Travel("London", "Paris", LocalDateTime.of(2018, Month.JUNE, 18, 16, 0), LocalDateTime.of(2018, Month.JUNE, 18, 17, 00), true));
		travels0.add(new Travel("Berlin", "Paris", LocalDateTime.of(2018, Month.JUNE, 18, 12, 0), LocalDateTime.of(2018, Month.JUNE, 18, 13, 00), true));
		
		// connnection travel
		//London_Milan
		travels0.add(new Travel("Zaragoza", "Milan", LocalDateTime.of(2018, Month.JUNE, 18, 9, 0), LocalDateTime.of(2018, Month.JUNE, 18, 17, 0), false));
		// London_Berlin
		travels0.add(new Travel("Zaragoza", "Berlin", LocalDateTime.of(2018, Month.JUNE, 18, 9, 0), LocalDateTime.of(2018, Month.JUNE, 18, 17, 0), false));
		// London_Paris
		travels0.add(new Travel("Zaragoza", "Paris", LocalDateTime.of(2018, Month.JUNE, 18, 9, 0), LocalDateTime.of(2018, Month.JUNE, 18, 17, 0), false));
		// Ber_Paris
		travels0.add(new Travel("Zaragoza", "Paris", LocalDateTime.of(2018, Month.JUNE, 18, 8, 0), LocalDateTime.of(2018, Month.JUNE, 18, 11, 0), false));
		
		travelRepository.saveAll(travels0);
		
		// Routes Zaragoza-London
		travels1.add(new Travel("London", "Milan", LocalDateTime.of(2018, Month.JUNE, 18, 15, 0), LocalDateTime.of(2018, Month.JUNE, 18, 17, 00), true));
		route1 = new Route("Zaragoza", "Milan",travels1);
		routeRepository.save(route1);
		
		travels2.add(new Travel("London", "Berlin", LocalDateTime.of(2018, Month.JUNE, 18, 16, 0), LocalDateTime.of(2018, Month.JUNE, 18, 17, 00), true));
		route2 = new Route("Zaragoza", "Berlin",travels2);
		routeRepository.save(route2);
		
		travels3.add(new Travel("London", "Paris", LocalDateTime.of(2018, Month.JUNE, 18, 16, 0), LocalDateTime.of(2018, Month.JUNE, 18, 17, 00), true));
		route3 = new Route("Zaragoza", "Paris",travels3);
		routeRepository.save(route3);
		
		// Routes Zaragoza-Berlin
		travels4.add(new Travel("Berlin", "Paris", LocalDateTime.of(2018, Month.JUNE, 18, 12, 0), LocalDateTime.of(2018, Month.JUNE, 18, 13, 00), true));
		route4 = new Route("Zaragoza", "Paris",travels4);
		routeRepository.save(route4);

		// Routes London-Berlin
		travels5.add(new Travel("Berlin", "Paris", LocalDateTime.of(2018, Month.JUNE, 18, 12, 0), LocalDateTime.of(2018, Month.JUNE, 18, 13, 00), true));
		route5 = new Route("London", "Paris",travels5);
		routeRepository.save(route5);
	}
}
