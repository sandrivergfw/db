package com.example.demo.relation;

import lombok.Data;

import java.util.Date;

@Data
public class Cart {
    private int customerId;
    private int productId;
    private boolean isSelect;
    private int num;
}
