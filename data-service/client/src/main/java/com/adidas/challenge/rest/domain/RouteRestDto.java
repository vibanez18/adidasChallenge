package com.adidas.challenge.rest.domain;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Info Route", description = "Complete data of a route entity Info")
public class RouteRestDto {
	
	@ApiModelProperty(value = "Id of the route", required = true)
	private Long id;
	@ApiModelProperty(value = "Name of the city of origin", required = true)
	private String city;
	@ApiModelProperty(value = "Name of the destination city", required = true)
	private String destinyCity;
	@ApiModelProperty(value = "Travel Connections", required = true)
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
