package com.example.demo.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult<E> implements Serializable {
    private int stateCode; //状态码
    private boolean success;//成功与否
    private String message;//描述信息
    private
}
