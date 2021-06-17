package com.hesen.blog.po;

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
public class Blog {
    private Long id;
    private String title;
    private String conent;
    private String firstPicture;
    private String flag;
    private Integer views;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentable;
    private boolean published;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;

    private Type type;
    private List<Tag> tags;
    private User user;
    private List<Comment> comments;
}
