package com.chungchun.website.post.common;

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
public class post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private int post_no;

    @Column(name = "ctg_code")
    private String ctg_code;

    @Column(name = "post_title")
    private String post_title;

    @Column(name = "post_content")
    private String post_content;

    @Column(name = "post_cdate")
    private Date post_cdate;

    @Column(name = "post_likes")
    private Integer post_likes;

    @ManyToOne
    @JoinColumn(name = "mc_no")
    private MyClass mc_no;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user_no;
}
