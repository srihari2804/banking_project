package com.hari.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.project.entity.AuditLog;

public interface AuditLogRepository
        extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findByUserId(Long userId);

}