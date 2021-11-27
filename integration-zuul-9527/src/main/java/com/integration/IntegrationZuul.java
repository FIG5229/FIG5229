package com.integration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import com.integration.filter.TokenFilter;



@SpringBootApplication
@EnableZuulProxy				//Zuul注解
//@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
@MapperScan({ "com.integration.api.dao", "com.integration.generator.dao", "com.integration.dao" })//session共享,每个模块都要添加
public class IntegrationZuul {
	public static void main(String[] args) {
		SpringApplication.run(IntegrationZuul.class, args);

	}
		@Bean
   public TokenFilter accessFilter() {
		return new TokenFilter();
	}
}
