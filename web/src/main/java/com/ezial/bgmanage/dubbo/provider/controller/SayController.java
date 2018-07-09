package com.ezial.bgmanage.dubbo.provider.controller;

import com.ezial.bgmanage.common.config.DogConf;
import com.ezial.bgmanage.common.model.TestTable;
import com.ezial.bgmanage.common.utils.SpringContextHolder;
import com.ezial.bgmanage.dao.mapper.TestTableMapper;
import com.ezial.bgmanage.dubbo.consumer.service.ITestService;
import com.ezial.bgmanage.dubbo.provider.dubbo.consumer.service.ITestService;
import com.ezial.bgmanage.service.ITestService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping(value = "/say")
@RestController
public class SayController {

    @Value("${whoIsGod}")
    private String god;

    @Resource
    private DogConf dogConf;

    //@Resource
    private ITestService testService;

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String sayHello() {
        return "Hello Spring Boot";
    }

    @GetMapping(value = "/tellmegod")
    public String tellmeGodName() {
        return "the God is " + god;
    }

    @GetMapping(value = "/dog")
    public String dog() {
        return "dog kind is " + dogConf.getKind() + " food is " + dogConf.getFood() + " weight is " + dogConf.getWeight();
    }

    @GetMapping(value = "/data")
    public String data() {
        testService = SpringContextHolder.getBean("testService");
        return testService.testSpringContextHold();
    }

    @GetMapping(value = "/test")
    public String test(@Param("temp") String temp) {
        int i = 1/0;
        return temp;
    }

    @PostMapping(value = "/testPost",produces = "application/json")
    public String testPost(@RequestBody TestTable temp) {
        System.out.println(temp);
        return temp.getId() + "";
    }

}
