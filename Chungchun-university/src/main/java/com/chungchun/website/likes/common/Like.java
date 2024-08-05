package com.chungchun.website.likes.common;

import com.chungchun.website.post.common.Post;
import com.chungchun.website.user.common.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="cc_like")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Like {

    @Id
    @Column(name = "like_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeNo;

    @Column(name = "create_date")
    // 생성일자
    private LocalDate createDate;

    @Column(name = "delete_date")
    private LocalDate dDate;

    @ManyToOne
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_no", nullable = false)
    private Post post;



}
