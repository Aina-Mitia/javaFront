package com.eni.encadrement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class EncadrementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncadrementApplication.class, args);
		
	}

}
