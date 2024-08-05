package com.colvir.colvirk8s;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    @Value("${hello.text}")
    private String helloText;

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(("/hello"))
    public String sayHello() {
        logger.info("Requested at {}", LocalDateTime.now());
        return helloText;
    }
}
