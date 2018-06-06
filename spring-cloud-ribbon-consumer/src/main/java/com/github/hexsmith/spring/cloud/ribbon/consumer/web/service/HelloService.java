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
package com.github.hexsmith.spring.cloud.ribbon.consumer.web.service;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2018/4/2 22:52
 */
public interface HelloService {
    /**
     * sayHello服务
     * @return
     */
    String sayHello();

}
