package com.hari.project.dto;

public class CustomerResponse {

    private Long id;
    private String customerNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String pincode;
    private String username;

    public CustomerResponse() {
    }

    public CustomerResponse(Long id, String customerNumber, String firstName, String lastName,
            String phone, String address, String pincode, String username) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.pincode = pincode;
        this.username = username;
    }

    public Long getId() { return id; }
    public String getCustomerNumber() { return customerNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getPincode() { return pincode; }
    public String getUsername() { return username; }
}
