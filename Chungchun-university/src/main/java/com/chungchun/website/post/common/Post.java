package com.chungchun.website.post.common;

import com.chungchun.website.course.common.Course;
import com.chungchun.website.user.common.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private int post_no;

    @Column(name = "ctg_code", nullable = false)
    private String ctg_code;

    @ManyToOne
    @JoinColumn(name = "cl_no")
    private Course course;

    @Column(name = "post_title", nullable = false)
    private String post_title;

    @Column(name = "post_content")
    private String post_content;

    @Column(name = "post_cdate",nullable = false)
    private Date post_cdate;

    @ManyToOne
    @JoinColumn(name = "user_no", nullable = false)
    private User user_no;
}
