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
package com.github.hexsmith.feign.consumer.controller;

import com.github.hexsmith.feign.consumer.model.User;
import com.github.hexsmith.feign.consumer.service.HelloService;
import com.github.hexsmith.feign.consumer.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2018/4/9 20:57
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }


    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(helloService.hello()).append("\n");
        stringBuilder.append(helloService.hello("hexsmith")).append("\n");
        stringBuilder.append(helloService.hello("hexsmith", "yuzhiping140103@hotmail.com")).append("\n");
        stringBuilder.append(helloService.hello(new User("hexsmith","yuzhiping140103@hotmail.com"))).append("\n");
        return stringBuilder.toString();
    }

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(refactorHelloService.hello()).append("\n");
        stringBuilder.append(refactorHelloService.hello("hexsmith")).append("\n");
        stringBuilder.append(refactorHelloService.hello("hexsmith", "yuzhiping140103@hotmail.com")).append("\n");
        stringBuilder.append(refactorHelloService.hello(new User("hexsmith","yuzhiping140103@hotmail.com"))).append("\n");
        return stringBuilder.toString();
    }


}
