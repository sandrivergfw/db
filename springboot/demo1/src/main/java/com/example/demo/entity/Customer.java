package com.example.demo.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Customer {
    private int customerId;
    private String customerName;
    private String loginPwd;
    private String phone;
    private String address;
    private Date birthday; //没有具体时分秒
    private String email;
    private String picUrl;
}
