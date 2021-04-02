package com.zuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}

}
