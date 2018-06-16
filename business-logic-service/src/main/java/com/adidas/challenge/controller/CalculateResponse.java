package com.adidas.challenge.controller;

import java.time.Duration;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Info calculate travels", description = "Complete data of a CalculateResponse entity Info")
public class CalculateResponse {
	
	@ApiModelProperty(value = "Name of the city of origin", required = true)
	private String city;
	@ApiModelProperty(value = "Name of the destination city", required = true)
	private String destinyCity;
	@ApiModelProperty(value = "Duration of travel (hh:mm)", required = true)
	private Duration duration;
	@ApiModelProperty(value = "Name of city of connection", required = true)
	private String connection;
	@ApiModelProperty(value = "Number of connections", required = true)
	private int numConnection;
	
	CalculateResponse(){
		this.numConnection = 0;
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
	
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	
	public int getNumConnection() {
		return numConnection;
	}
	public void setNumConnection(int numConnection) {
		this.numConnection = numConnection;
	}
}
