package com.example.demo.mapper;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select * from comments where productId=#{productId}")
    public List<Comment> getCommentByProductId(@Param("productId") int productId);

    @Update("update comments set commentLike=commentLike+1 where commentId=#{commentId}")
    public int addCommentLike(@Param("commentId")int commentId);


    @Update("update comments set commentLike=commentLike-1 where commentId=#{commentId} and commentLike>=1")
    public int delCommentLike(@Param("commentId")int commentId);

    @Update("update comments set commentDislike=commentDislike+1 where commentId=#{commentId}")
    public int addCommentDislike(@Param("commentId")int commentId);


    @Update("update comments set commentLike=commentLike-1 where commentId=#{commentId} and commentLike>=1")
    public int delCommentDislike(@Param("commentId")int commentId);

    @Update("update comments set commentReplys=commentReplys+1 where commentId=#{commentId}")
    public int addReply(@Param("commentId")int commentId);

}
