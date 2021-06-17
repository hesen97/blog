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
public class Comment {
    private Long id;
    private String nickname;
    private String email;
    private String avatar;
    private String content;
    private Date createTime;

    private Blog blog;
    private Comment comment;
    private List<Comment> replyComments;
}
