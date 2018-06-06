package com.github.hexsmith.spring.cloud.turbine.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @author yuzhi
 */
@EnableTurbineStream
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudTurbineAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTurbineAmqpApplication.class, args);
    }
}
