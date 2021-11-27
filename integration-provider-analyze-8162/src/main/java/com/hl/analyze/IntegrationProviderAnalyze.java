package com.hl.analyze;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jason
 * @date 2021/10/21 10:00
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.integration.api.dao", "com.integration.generator.dao", "com.hl.analyze.dao"})
public class IntegrationProviderAnalyze {
    public static void main(String[] args) {
        SpringApplication.run(IntegrationProviderAnalyze.class, args);
    }

}
