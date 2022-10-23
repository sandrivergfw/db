package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.CustomerlikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //组合注解 是GetMapping的基础
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CustomerlikeMapper customerlikeMapper;


    @RequestMapping("/getProductComment")
    public List<Comment> getCommentByProduct(@RequestParam("productId") int productId){
        return commentMapper.getCommentByProductId(productId);
    }

    @RequestMapping("/likeComment")
    public boolean likeComment(@RequestParam("customerId")int customerId,
                               @RequestParam("commentId")int commentId){
        if (customerlikeMapper.checkLikeComment(customerId,commentId)==null){
            customerlikeMapper.likeComment(customerId,commentId);
            return commentMapper.addCommentLike(commentId)==1;
        }else {
            customerlikeMapper.cancelLikeComment(customerId, commentId);
            return commentMapper.delCommentLike(commentId)==1;
        }
    }

    @RequestMapping("/dislikeComment")
    public boolean dislikeComment(@RequestParam("customerId")int customerId,
                               @RequestParam("commentId")int commentId){
        if (customerlikeMapper.checkDislikeComment(customerId,commentId)==null){
            customerlikeMapper.dislikeComment(customerId,commentId);
            return commentMapper.addCommentDislike(commentId)==1;
        }else {
            customerlikeMapper.cancelDislikeComment(customerId, commentId);
            return commentMapper.delCommentDislike(commentId)==1;
        }
    }



}
