package com.example.demo.mapper;

import com.example.demo.entity.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface ReplyMapper {
    @Select("select * from replys where commentId=#{commentId}")
    List<Reply> getReplyByComment(@Param("commentId")int commentId);

    @Insert("insert into replys set replyText=#{replyText},replyTime=#{replyTime},customerId=#{customerId},commentId=#{commentId}")
    int insertReply(@Param("replyText")String replyText,
                    @Param("replyTime") Timestamp replyTime,
                    @Param("customerId")int customerId,
                    @Param("commentId")int commentId);
}
