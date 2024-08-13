package com.chungchun.website.comment.model;

import com.chungchun.website.comment.repository.CommentRepository;
import com.chungchun.website.post.model.Post;
import com.chungchun.website.user.model.User;

import java.util.Date;

public class AddCommentRequest {
    private int cmtNo;
    private String cmtContent;
    private User user;
    private Post post;
    private Date cmtCreateDate;
    private Date cmtUpDate;

    public Comment toEntity(){
        // 생성자를 사용해 객체 생성
        return Comment.builder()
                .cmtContent(cmtContent)
                .cmtCreateDate(cmtCreateDate)
                .cmtUpDate(cmtUpDate)
                .user(user)
                .post(post)
                .build();

    }

}
