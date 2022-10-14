package com.example.demo.entity;

import lombok.Data;

@Data
public class Product {
    private int productId;
    private String productName;
    private double price;
    private double size;//电脑尺寸
    private String picture;
    private int SSD;
    private int memory;
    private int sales;//销量
    private String brand;




}
