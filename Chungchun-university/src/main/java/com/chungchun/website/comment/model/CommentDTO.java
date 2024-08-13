package com.chungchun.website.comment.model;

import com.chungchun.website.post.model.Post;
import com.chungchun.website.user.model.User;
import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommentDTO {

    private int cmtNo;
    private String cmtContent;
    private User user;
    private Post post;
    private Date cmtCreateDate;
    private Date cmtUpDate;
    private String comment;
}
