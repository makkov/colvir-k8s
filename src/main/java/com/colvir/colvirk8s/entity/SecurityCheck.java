package com.colvir.colvirk8s.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class SecurityCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private SecurityCheckStatus status;

    private LocalDateTime statusDate;

    public SecurityCheck() {
    }

    public SecurityCheck(SecurityCheckStatus status, LocalDateTime statusDate) {
        this.status = status;
        this.statusDate = statusDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SecurityCheckStatus getStatus() {
        return status;
    }

    public void setStatus(SecurityCheckStatus status) {
        this.status = status;
    }

    public LocalDateTime getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(LocalDateTime statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityCheck that = (SecurityCheck) o;
        return Objects.equals(id, that.id) && status == that.status && Objects.equals(statusDate, that.statusDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, statusDate);
    }

    @Override
    public String toString() {
        return "SecurityCheck{" +
                "id=" + id +
                ", status=" + status +
                ", statusDate=" + statusDate +
                '}';
    }
}
