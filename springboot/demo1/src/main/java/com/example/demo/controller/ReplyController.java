package com.example.demo.controller;

import com.example.demo.entity.Reply;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController  //组合注解 是GetMapping的基础
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private CommentMapper commentMapper;

    @RequestMapping("/getCommentReply")
    public List<Reply> getReplyUnderComment(@RequestParam("commentId") int commentId){
        return  replyMapper.getReplyByComment(commentId);
    }
    @RequestMapping("/postAnReply")
    public boolean postAnReply(@RequestParam("customerId")int customerId,
                               @RequestParam("commentId")int commentId,
                               @RequestParam("replyText")String replyText){
        replyMapper.insertReply(replyText,new Timestamp(System.currentTimeMillis()),customerId,commentId);
        return commentMapper.addReply(commentId)==1;
    }

}
