package com.noriental.feignconsumer.controller;

import com.noriental.feignconsumer.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/feign-consumer")
    public String consumerHello() {
        return consumerService.hello();
    }
}
