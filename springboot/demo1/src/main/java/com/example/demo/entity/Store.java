package com.example.demo.entity;

import lombok.Data;

@Data
public class Store {
    private int storeId;
    private String storeName;
    private String storePwd;
    private double storeScore;
    private int storeFollowers;
}
