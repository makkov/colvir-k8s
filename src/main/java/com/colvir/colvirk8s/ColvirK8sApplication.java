package com.colvir.colvirk8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ColvirK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColvirK8sApplication.class, args);
    }

}
