package com.hesen.blog.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_blog")
public class Blog {
    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private Boolean appreciation;
    private Boolean shareStatement;
    private Boolean commentable;
    private Boolean published;
    private Boolean recommend;
    private Date createTime;
    private Date updateTime;
    private Long typeId;
    private Long userId;

    @TableField(exist = false)
    private Type type;
    @TableField(exist = false)
    private List<Tag> tags;
    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private List<Comment> comments;
}
