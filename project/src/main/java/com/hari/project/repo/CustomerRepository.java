package com.hari.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.project.entity.Customer;
import com.hari.project.enums.Role;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	 List<Customer> findByUserRole(Role role);

}
