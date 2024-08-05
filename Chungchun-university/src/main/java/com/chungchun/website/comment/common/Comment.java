package com.chungchun.website.comment.common;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "comment")
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmt_no")
    private int cmt_no;

    @Column(name = "cmt_content", nullable = false)
    private int cmt_content;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_no")
    private Post post;

    @Column(name = "cmt_cdate", nullable = false)
    private int cmt_cdate;

    @Column(name = "cmt_udate", nullable = false)
    private int cmt_udate;




}
