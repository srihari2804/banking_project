package com.hari.project.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.project.dto.CustomerResponse;
import com.hari.project.service.CustomerService;

@RestController
//@RequestMapping("/api/customers")
@RequestMapping("/api/admin/customers")
public class CustomerController {

//    private CustomerService customerService;
//
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @GetMapping
//    public List<CustomerResponse> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }
//
//    @GetMapping("/{id}")
//    public CustomerResponse getCustomer(@PathVariable Long id) {
//        return customerService.getCustomerById(id);
//    }
}
