package com.ezial.bgmanage.dubbo.provider.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ezial.bgmanage.dubbo.consumer.DemoService;
import com.ezial.bgmanage.dubbo.consumer.service.ITestService;
import com.ezial.bgmanage.dubbo.provider.dubbo.consumer.service.ITestService;
import com.ezial.bgmanage.service.ITestService;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/say")
@RestController
public class SayController {

    //@Resource
    private ITestService testService;

    @Reference(version = "${consumer.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345"
    )
    private static DemoService demoService;

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String sayHello() {
        return "Hello Spring Boot";
    }

    @GetMapping("sayHello")
    public String sayHello(@RequestParam String name){
        return demoService.sayHello(name);
    }


}
