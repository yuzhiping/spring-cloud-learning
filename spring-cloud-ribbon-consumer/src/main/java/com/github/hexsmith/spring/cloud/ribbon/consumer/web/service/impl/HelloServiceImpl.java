/*
 *Copyright  (C) 2016-2018 The hexsmith Authors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.github.hexsmith.spring.cloud.ribbon.consumer.web.service.impl;

import com.github.hexsmith.spring.cloud.ribbon.consumer.web.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2018/4/2 22:53
 */
@Service
public class HelloServiceImpl implements HelloService {


    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * sayHello服务
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloFallback")
    @Override
    public String sayHello() {
        long start = System.currentTimeMillis();
        String response = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("spend time: " + (end-start));
        return response;

    }

    public String helloFallback() {
        return "invoke service error";
    }

}
