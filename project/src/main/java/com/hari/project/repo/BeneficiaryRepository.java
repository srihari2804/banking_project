package com.hari.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.project.entity.Beneficiary;
import com.hari.project.entity.Customer;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long>{
	List<Beneficiary> findByCustomerId(Long customerId);
}
