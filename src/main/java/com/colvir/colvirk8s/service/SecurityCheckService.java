package com.colvir.colvirk8s.service;

import com.colvir.colvirk8s.entity.SecurityCheck;
import com.colvir.colvirk8s.repository.SecurityCheckRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static com.colvir.colvirk8s.entity.SecurityCheckStatus.*;

@Service
public class SecurityCheckService {

    private final SecurityCheckRepository securityCheckRepository;
    private final Random random = new Random();

    public SecurityCheckService(SecurityCheckRepository securityCheckRepository) {
        this.securityCheckRepository = securityCheckRepository;
    }

    public void create(LocalDateTime currentDateTime) {
        SecurityCheck newSecurityCheck = new SecurityCheck(CREATED, currentDateTime);
        newSecurityCheck = securityCheckRepository.save(newSecurityCheck);
        System.out.printf("SecurityCheck saved: %s\n", newSecurityCheck);
    }

    public void doCheck(LocalDateTime currentDateTime) {
        List<SecurityCheck> securityChecks = securityCheckRepository.findByStatus(CREATED);

        //логика отправки на проверку во внешнюю систему ...
        securityChecks.stream()
                .forEach(sc -> {
                    if (random.nextBoolean()) {
                        sc.setStatus(APPROVED);
                    } else {
                        sc.setStatus(REJECTED);
                    }
                    sc.setStatusDate(currentDateTime);
                });

        securityChecks = securityCheckRepository.saveAll(securityChecks);
        System.out.printf("SecurityChecks after update: %s\n", securityChecks);
    }
}
