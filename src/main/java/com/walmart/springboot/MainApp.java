package com.walmart.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"hello","com.walmart.springboot"})
@EnableCaching
@SpringBootApplication
public class MainApp {
	
	/*
	 * initiate cache manager in startup
	 */
	@Autowired
    private CacheManager cacheManager;
	
   public static void main(String[] args) {
      SpringApplication.run(MainApp.class, args);
   }
}