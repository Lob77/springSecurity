package com.project.springsecurity.admin.repository;

import com.project.springsecurity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByUserId(String userId);
}
