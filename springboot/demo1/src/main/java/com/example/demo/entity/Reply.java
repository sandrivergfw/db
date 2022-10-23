package com.example.demo.entity;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class Reply {
    private int replyId;
    private String replyText;
    private Timestamp replyTime;
    private int replyLike;
    private int replyDislike;
    private int customerId;
    private int commentId;
}
