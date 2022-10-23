package com.example.demo.entity;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class Comment {
    private int commentId;
    private String commentText;
    private double commentScore;
    private Timestamp commentTime;
    private int commentLike;
    private int commentDislike;
    private int commentReplys ;
    private int customerId;
    private int productId;
}
