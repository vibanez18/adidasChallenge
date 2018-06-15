package com.adidas.challenge.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Route {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String city;
	@NotNull
	private String destinyCity;
	@NotNull
	@OneToMany (cascade = CascadeType.ALL)
	private List<Travel> travels;
	
	public Route() {
		super();
	}
	public Route(String city, String destinyCity, List<Travel> travels) {
		this.city = city;
		this.destinyCity = destinyCity;
		this.travels = travels;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Travel> getTravels() {
		return travels;
	}
	public void setTravels(List<Travel> travels) {
		this.travels = travels;
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

}
