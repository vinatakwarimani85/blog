package com.firstTry.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EntityScan("com.firstTry.demo.user")
//@ComponentScan(basePackages = {"com.firstTry.demo.exceptions","com.firstTry.demo.ResponseHandler.copy","com.firstTry.demo.user",
//		"com.firstTry.demo.uttils"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
