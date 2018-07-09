package com.ezial.bgmanage.dubbo.provider.dubbo.consumer.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "dog")
@Data
public class DogConf {
    private String food = "apple";

    private Integer weight = 100;

    private String kind = "100per";

}
