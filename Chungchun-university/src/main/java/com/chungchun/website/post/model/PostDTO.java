package com.chungchun.website.post.model;

import com.chungchun.website.course.model.Course;
import com.chungchun.website.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostDTO {

    private int postNo;
    private String categoryCode;
    private Course clsNo;
    private String postTitle;
    private String postContent;
    private Date postCreateDate;
    private User userNo;
}
