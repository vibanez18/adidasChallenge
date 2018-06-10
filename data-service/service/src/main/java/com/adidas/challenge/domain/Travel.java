package com.adidas.challenge.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Travel {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String city;
	@NotNull
	private String destinyCity;
	@NotNull
	private LocalDateTime departureTime;
	@NotNull
	private LocalDateTime arrivalTime;
	
	public Travel() {
		super();
	}
	
	public Travel(String city, String destinyCity, LocalDateTime departureTime, LocalDateTime arrivalTime) {
		this();
		this.arrivalTime = arrivalTime;
		this.city = city;
		this.departureTime = departureTime;
		this.destinyCity = destinyCity;
	}
	
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
	

}
