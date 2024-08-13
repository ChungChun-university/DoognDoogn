package com.chungchun.website.comment.model;

import com.chungchun.website.post.model.Post;
import com.chungchun.website.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity(name = "comment")
@Table(name = "cc_comment")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmt_no")
    private int cmtNo;

    @Column(name = "cmt_content", nullable = false)
    private String cmtContent;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_no")
    private Post post;

    @Column(name = "cmt_create_date", nullable = false)
    @CreatedDate
    private Date cmtCreateDate;

    @Column(name = "cmt_up_date", nullable = false)
    @LastModifiedDate
    private Date cmtUpDate;






}
