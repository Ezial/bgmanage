package com.ezial.bgmanage.dubbo.provider.controller;

import com.alibaba.dubbo.config.annotation.Service;
import com.ezial.bgmanage.dubbo.provider.dubbo.consumer.dubbo.consumer.DemoService;

@Service(
        version="${provider.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DefaultDemoService implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello," + name + "(from Spring Boot)";
    }
}
