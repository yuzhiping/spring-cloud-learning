package com.github.hexsmith.spring.cloud.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2019-09-16 22:35
 */
@SpringBootApplication
@RestController
public class SleuthApplication {


    private static final Logger LOGGER = LoggerFactory.getLogger(SleuthApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SleuthApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        LOGGER.info("Handling home");
        return "Hello World";
    }

}
