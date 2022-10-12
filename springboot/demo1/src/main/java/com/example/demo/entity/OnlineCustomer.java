package com.example.demo.entity;

public class OnlineCustomer extends Customer{
    private String token;

    public OnlineCustomer(Customer customer) {
        super.customerId = customer.getCustomerId();
    }

    public void setToken(String a) {
        this.token = a;
    }

    public String getToken() {
        return token;
    }
}
