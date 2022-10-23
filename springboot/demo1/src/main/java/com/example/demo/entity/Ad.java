package com.example.demo.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class Ad {
    private int adId;
    private String adText;
    private Time adTime;
    private String adTitle;
    private String adPic;

}
