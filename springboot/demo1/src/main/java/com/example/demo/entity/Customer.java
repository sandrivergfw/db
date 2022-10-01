package com.example.demo.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Customer {
    private int customerId;
    private String loginPwd;
    private String payPwd;
    private String customerName;
    private boolean sex; //1为男 0为女
    private String phone;
    private String address;
    private Date birthday; //没有具体时分秒
    private String email;
}
