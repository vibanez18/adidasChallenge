package com.adidas.challenge.rest.domain;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Info travel", description = "Complete data of a travel entity Info")
public class TravelRestDto {
	
	@ApiModelProperty(value = "Id of the travel", required = true)
	private Long id;
	@ApiModelProperty(value = "Name of the city of origin", required = true)
	private String city;
	@ApiModelProperty(value = "Name of the destination city", required = true)
	private String destinyCity;
	@ApiModelProperty(value = "Date/Time of departure", required = true)
	private LocalDateTime departureTime;
	@ApiModelProperty(value = "Date/Time of arrival", required = true)
	private LocalDateTime arrivalTime;
	@ApiModelProperty(value = "Travel direct or with connections", required = true)
	private boolean direct;
	
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
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public boolean isDirect() {
		return direct;
	}
	public void setDirect(boolean direct) {
		this.direct = direct;
	}

}
