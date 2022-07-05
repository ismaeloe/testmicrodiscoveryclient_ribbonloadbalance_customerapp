package com.cjava.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class ConsumidorController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/health")
	public String ok() {
		return "ok";
	}
	
	@GetMapping(value = "/customers")
	public String getCustomers()
	{
		//String url ="http://mseureka-servicio/rest/hola/server";
		//String url ="http://localhost:8071/rest/hola/server";

		/*java.lang.IllegalStateException: No instances available for localhost
		 * at org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient.execute(RibbonLoadBalancerClient.java:119) ~[spring-cloud-netflix-ribbon-2.2.5.RELEASE
		 * 	String url ="http://localhost:8092/customers/health";
		 * 
		 * Request processing failed; nested exception is java.lang.IllegalStateException: No instances available for 192.168.56.1] with root cause
		 * java.lang.IllegalStateException: No instances available for 192.168.56.1
		 * 		String url ="http://192.168.56.1:8092/customers/health";
		 */

		String url ="http://customer-service/customers/health";

		return restTemplate.getForObject( url ,String.class);
	}

}
