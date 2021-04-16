package com.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan({"com.commonsservice.entities"})
public class ServicioProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioProductoApplication.class, args);
		System.out.println("Working producto");
	}

}
