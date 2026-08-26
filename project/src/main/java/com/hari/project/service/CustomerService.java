package com.hari.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hari.project.dto.CustomerResponse;
import com.hari.project.entity.Customer;
import com.hari.project.enums.Role;
import com.hari.project.repo.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponse> getAllCustomers() {

        return customerRepository.findByUserRole(Role.USER).stream()
                .map(this::convertToResponse)
                .toList();
    }

    public CustomerResponse getCustomerById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return convertToResponse(customer);
    }

    private CustomerResponse convertToResponse(Customer customer) {

        String username = customer.getUser() != null
                ? customer.getUser().getUsername()
                : "";

        return new CustomerResponse(
                customer.getId(),
                customer.getCustomerNumber(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getPincode(),
                username
        );
    }
}