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
package com.github.hexsmith.spring.cloud.boot.web.controller;

import com.github.hexsmith.spring.cloud.service.api.model.User;
import com.github.hexsmith.spring.cloud.service.api.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2018/4/12 21:32
 */
@RestController
public class RefactorHelloController implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello" + name;
    }

    @Override
    public User hello(String username, String email) {
        return new User(username,email);
    }

    @Override
    public String hello(User user) {
        return "hello" + user.getUsername() + "," + user.getEmail();
    }
}
