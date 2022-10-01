package com.example.demo.utils;

import lombok.Data;

@Data
public class Filter {
    private String brand;
    private double price1;
    private double price2;
    private double size;
    private int sales;
    private String sortIndex; //排序标准
    private String order; //升序或降序，只能是DESC和ASC取值
}
