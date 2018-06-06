package com.github.hexsmith.spring.cloud.api.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author yuzhi
 */
@EnableZuulProxy
@SpringBootApplication
public class SpringCloudApiGatewayApplication {

    public static void main(String[] args) {
        new  SpringApplicationBuilder(SpringCloudApiGatewayApplication.class).web(true).run(args);
    }
}
