package com.noriental.serviceprodiver.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;

@RestController
@EnableEurekaClient
public class HelloController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    //private DiscoveryClient client;
    private EurekaDiscoveryClient client;

    @GetMapping("/hello")
    public String index() {
        //logger.info();
        return "hello world PID:" + ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
    }

}
