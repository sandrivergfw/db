package com.example.demo.mapper;

import com.example.demo.relation.Customer_comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerlikeMapper {

    @Select("select 1 from customerlikecomment where customerId=#{customerId} and commentId=#{commentId} limit 1")
    Integer checkLikeComment(@Param("customerId")int customerId, @Param("commentId")int commentId);

    @Select("select 1 from customerdislikecomment where customerId=#{customerId} and commentId=#{commentId} limit 1")
    Integer checkDislikeComment(@Param("customerId")int customerId,@Param("commentId")int commentId);

    @Select("select 1 from customerlikecomment where customerId=#{customerId} and replyId=#{replyId} limit 1")
    Integer checkLikeReply(@Param("customerId")int customerId,@Param("replyId")int replyId);

    @Select("select 1 from customerdislikecomment where customerId=#{customerId} and replyId=#{replyId} limit 1")
    Integer checkDislikeReply(@Param("customerId")int customerId,@Param("replyId")int replyId);

    @Insert("insert into customerlikecomment set customerId=#{customerId},commentId=#{commentId}")
    int likeComment(@Param("customerId")int customerId,@Param("commentId")int commentId);

    @Delete("delete from customerlikecomment where customerId=#{customerId} and commentId=#{commentId}")
    int cancelLikeComment(@Param("customerId")int customerId,@Param("commentId")int commentId);

    @Insert("insert into customerlikereply set customerId=#{customerId},replyId=#{replyId}")
    int likeReply(@Param("customerId")int customerId,@Param("replyId")int commentId);

    @Delete("delete from customerlikereply where customerId=#{customerId} and replyId=#{replyId}")
    int cancelLikeReply(@Param("customerId")int customerId,@Param("replyId")int replyId);


    @Insert("insert into customerdislikecomment set customerId=#{customerId},commentId=#{commentId}")
    int dislikeComment(@Param("customerId")int customerId,@Param("commentId")int commentId);

    @Delete("delete from customerdislikecomment where customerId=#{customerId} and commentId=#{commentId}")
    int cancelDislikeComment(@Param("customerId")int customerId,@Param("commentId")int commentId);

    @Insert("insert into customerdislikereply set customerId=#{customerId},replyId=#{replyId}")
    int dislikeReply(@Param("customerId")int customerId,@Param("replyId")int commentId);

    @Delete("delete from customerdislikereply where customerId=#{customerId} and replyId=#{replyId}")
    int cancelDislikeReply(@Param("customerId")int customerId,@Param("replyId")int replyId);
}
