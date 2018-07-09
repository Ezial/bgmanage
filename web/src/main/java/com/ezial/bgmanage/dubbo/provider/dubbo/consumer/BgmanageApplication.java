package com.ezial.bgmanage.dubbo.provider.dubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@ComponentScan(basePackages = {"com.ezial.bgmanage"})
public class BgmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgmanageApplication.class, args);
    }
}
