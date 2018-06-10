package com.adidas.challenge.controller.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@EnableFeignClients
public class BusinessLogicControllerTest {
	
	@Autowired
    private TestRestTemplate testRestTemplate;
	
	@Test
	public void calculateTravelByTimeTest() {
//		testRestTemplate.postForEntity("http://localhost:8003/calculate/bytime", request, responseType)
	}

}
