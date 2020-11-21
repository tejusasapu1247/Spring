package com.demo3.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/*
 * <context:annotation-config/>
 * <context
 * 
 * 
 */
@Configuration
@ComponentScan(basePackages= {"com.demo2"})
public class AppConfig {

}
