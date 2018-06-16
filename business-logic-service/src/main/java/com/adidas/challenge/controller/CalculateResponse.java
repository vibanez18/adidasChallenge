package com.adidas.challenge.controller;

import java.time.Duration;

public class CalculateResponse {
	
	private String city;
	private String destinyCity;
	private Duration duration;
	private String connection;
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
