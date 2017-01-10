package com.example;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@Service
public class RestClient {
	
	@HystrixCommand(fallbackMethod="fallbackMessage",commandProperties={
			@HystrixProperty(name="execution.isolation.strategy",value="THREAD")
	})
	public String getMessage(String name){
		RestTemplate restTemplate = new RestTemplate();
	    URI uri = URI.create("http://localhost:8080/hello/"+name);
	    return restTemplate.getForObject(uri, String.class);
	}
	
	public String fallbackMessage(String name)
	{
		return "welcome "+name +" !!!";
	}
}
