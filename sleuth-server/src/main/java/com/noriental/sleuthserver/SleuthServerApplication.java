package com.noriental.sleuthserver;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class SleuthServerApplication {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SleuthServerApplication.class);

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/trace-1")
    public String trace(){
        logger.info("===call trace-1===");
        return restTemplate().getForEntity("http://trace-2/trace-2",
                String.class).getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(SleuthServerApplication.class, args);
    }
}
