package com.walmart.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.walmart.springboot.*"})
@EnableCaching
@SpringBootApplication
public class MainApp {
	
   public static void main(String[] args) {
      SpringApplication.run(MainApp.class, args);
   }
   
}