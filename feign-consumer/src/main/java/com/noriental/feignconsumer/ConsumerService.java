package com.noriental.feignconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("SERVICE-PROVIDER")
public interface ConsumerService {

    @GetMapping("/hello")
    String hello();
}
