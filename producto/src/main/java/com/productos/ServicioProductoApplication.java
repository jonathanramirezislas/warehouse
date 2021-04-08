package com.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ServicioProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioProductoApplication.class, args);
		System.out.println("Working producto");
	}

}
