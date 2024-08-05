package com.colvir.colvirk8s.scheduler;

import com.colvir.colvirk8s.service.SecurityCheckService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Scheduler {

    private final SecurityCheckService securityCheckService;

    public Scheduler(SecurityCheckService securityCheckService) {
        this.securityCheckService = securityCheckService;
    }

    @Scheduled(fixedDelay = 3000)
    public void createSecurityCheck() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.printf("createSecurityCheck started at %s\n", currentDateTime);
        securityCheckService.create(currentDateTime);
    }

    @Scheduled(fixedDelay = 5000)
    public void doCheck() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.printf("doCheck started at %s\n", currentDateTime);
        securityCheckService.doCheck(currentDateTime);
    }
}
