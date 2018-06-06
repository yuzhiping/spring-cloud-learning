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
package com.github.hexsmith.feign.consumer.service;

import com.github.hexsmith.feign.consumer.configuration.FullLogConfiguration;
import com.github.hexsmith.feign.consumer.configuration.HelloServiceFallback;
import com.github.hexsmith.feign.consumer.configuration.HystrixConfiguration;
import com.github.hexsmith.feign.consumer.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2018/4/9 20:51
 */
@FeignClient(value = "hello-service", configuration = {HystrixConfiguration.class, FullLogConfiguration.class}, fallback = HelloServiceFallback.class)
public interface HelloService {

    /**
     * 问候接口
     * @return
     */
    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("email") String email);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);

}
