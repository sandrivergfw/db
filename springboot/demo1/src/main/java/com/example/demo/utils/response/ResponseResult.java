package com.example.demo.utils.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult<E> implements Serializable {
    private int stateCode; //状态码
    private boolean success;//成功与否
    private String message;//描述信息
    private E data ;//需要被转换成Json格式的数据对象

    public ResponseResult(int stateCode,boolean success,String message,E data){
        this.stateCode = stateCode;
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public ResponseResult(){}
}
