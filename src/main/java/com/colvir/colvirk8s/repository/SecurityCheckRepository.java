package com.colvir.colvirk8s.repository;

import com.colvir.colvirk8s.entity.SecurityCheck;
import com.colvir.colvirk8s.entity.SecurityCheckStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecurityCheckRepository extends JpaRepository<SecurityCheck, Long> {

    List<SecurityCheck> findByStatus(SecurityCheckStatus status);
}
