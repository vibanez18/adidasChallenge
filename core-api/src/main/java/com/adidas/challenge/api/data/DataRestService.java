package com.adidas.challenge.api.data;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

public interface DataRestService {
	
	/**
	 * The Interface CLIENT.
	 */
	@FeignClient("adidas-data")
	interface CLIENT extends DataRestService {
	}
	
	List<TravelDto> findTravelByCityOrderByConnections(String city);
	List<TravelDto> findTravelByCityOrderByTime(String city);
}
