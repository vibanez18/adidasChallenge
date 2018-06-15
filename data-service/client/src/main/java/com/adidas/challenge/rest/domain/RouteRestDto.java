package com.adidas.challenge.rest.domain;

import java.util.List;

public class RouteRestDto {
	private Long id;
	private String city;
	private String destinyCity;
	private List<TravelRestDto> travels;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDestinyCity() {
		return destinyCity;
	}
	public void setDestinyCity(String destinyCity) {
		this.destinyCity = destinyCity;
	}
	public List<TravelRestDto> getTravels() {
		return travels;
	}
	public void setTravels(List<TravelRestDto> travels) {
		this.travels = travels;
	}
}
