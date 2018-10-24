package com.mao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


/**
 * 自定义ribbon   时  自定义MySelfRule类  不能和@ComponentScan
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.mao.springcloud"})
@ComponentScan("com.mao.springcloud")
public class DeptConsumer80_Feign_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}
}
