package com.example.cloudconsumerorder8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudConsumerOrder8002Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudConsumerOrder8002Application.class, args);
	}

}
