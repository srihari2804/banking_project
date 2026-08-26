package com.hari.project.entity;

import java.time.LocalDateTime;

import com.hari.project.enums.BeneficiaryStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Beneficiary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="customer_id" , nullable=false)
	private Customer customer;
	
	private String beneficiaryName;
	private String accountNumber;
	private String bankName;
	private String ifscCode;
	
	@Enumerated(EnumType.STRING)
	private BeneficiaryStatus status;
	private LocalDateTime createdAt;
	
	public Beneficiary() {
		// TODO Auto-generated constructor stub
	}
	public Beneficiary(Long id, Customer customer, String beneficiaryName, String accountNumber, String bankName,
			String ifscCode, BeneficiaryStatus status, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.customer = customer;
		this.beneficiaryName = beneficiaryName;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.status = status;
		this.createdAt = createdAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public BeneficiaryStatus getStatus() {
		return status;
	}
	public void setStatus(BeneficiaryStatus status) {
		this.status = status;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}