package com.github.hexsmith.spring.cloud.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudBootApplication.class, args);
	}
}
