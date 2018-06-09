package com.adidas.challenge.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.adidas.challenge.rest.service.DataRestService;

@SpringBootTest
@EnableFeignClients(basePackages = "com.adidas.challenge.api")
public class DataRestServiceTest {
	
	@Autowired private DataRestService dataRestService;

}
