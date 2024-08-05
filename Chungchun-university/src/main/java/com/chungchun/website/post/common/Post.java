package com.chungchun.website.post.common;

import com.chungchun.website.course.common.Course;
import com.chungchun.website.user.common.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "cc_post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private int postNo;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "post_create_date")
    private Date postCreateDate;

    @Column(name = "post_likes")
    private Integer postLikes;

    @ManyToOne
    @JoinColumn(name = "cls_no")
    private Course clsNo;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User userNo;
}
