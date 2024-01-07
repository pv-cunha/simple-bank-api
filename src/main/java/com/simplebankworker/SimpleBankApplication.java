package com.simplebankworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SimpleBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBankApplication.class, args);
	}

}
