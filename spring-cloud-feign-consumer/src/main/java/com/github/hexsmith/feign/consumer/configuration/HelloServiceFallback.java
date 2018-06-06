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
package com.github.hexsmith.feign.consumer.configuration;

import com.github.hexsmith.feign.consumer.model.User;
import com.github.hexsmith.feign.consumer.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2018/4/12 22:41
 */
@Component
public class HelloServiceFallback implements HelloService {
    /**
     * 问候接口
     *
     * @return
     */
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, String email) {
        return new User("未知", "service@qq.com");
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
