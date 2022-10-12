package com.example.demo.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Customer {
    protected int customerId;
    protected String loginPwd;
    protected String payPwd;
    protected String customerName;
    protected boolean sex; //1为男 0为女
    protected String phone;
    protected String address;
    protected Date birthday; //没有具体时分秒
    protected String email;

    public int getCustomerId() {
        return customerId;
    }
}
