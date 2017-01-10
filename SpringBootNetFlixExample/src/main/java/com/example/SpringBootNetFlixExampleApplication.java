package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class SpringBootNetFlixExampleApplication {
	@Autowired
	private RestClient client;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootNetFlixExampleApplication.class, args);
	}
	
	@GetMapping("/client/{name}")
	public String sayHello(@PathVariable String name)
	{
		return client.getMessage(name);
	}
}
