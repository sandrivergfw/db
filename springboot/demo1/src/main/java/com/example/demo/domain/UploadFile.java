package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Timestamp;

//@ApiModel(value="用户信息")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("upload_file")
public class UploadFile implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    private String realName;

    private String fileName;
    private String primaryName;
    private String extension;
    private String path;
    private String type;
    private int size;
    private int uploaderId;
    private Timestamp createTime;
}
