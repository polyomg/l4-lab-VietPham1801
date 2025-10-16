package com.poly.lab6.lab6_jparepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.poly.lab6.lab6_jparepository") 
public class Lab6JparepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab6JparepositoryApplication.class, args);
	}

}
