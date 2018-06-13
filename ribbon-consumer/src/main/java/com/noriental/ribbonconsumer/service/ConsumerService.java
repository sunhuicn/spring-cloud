package com.noriental.ribbonconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    public String consumerService() {
        return restTemplate.getForEntity("http://SERVICE-PROVIDER/hello",String.class).getBody();
    }

    public String consumerFallback() {
        return "ERROR";
    }

}
