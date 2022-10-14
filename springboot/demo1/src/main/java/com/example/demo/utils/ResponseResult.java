package com.example.demo.utils;

import lombok.Data;

@Data
public class ResponseResult {
    private int code ; //状态码
    private boolean success;
    private String message;
}
