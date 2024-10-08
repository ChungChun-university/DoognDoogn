package com.chungchun.website.post.model;

import com.chungchun.website.comment.model.Comment;
import com.chungchun.website.course.model.Course;
import com.chungchun.website.likes.model.Like;
import com.chungchun.website.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cc_post")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder(toBuilder = true)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private int postNo;

    @Column(name = "category_code", nullable = false)
    private String categoryCode;

    @ManyToOne
    @JoinColumn(name = "cls_no")
    private Course clsNo;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "post_create_date", nullable = false)
    @CreatedDate
    private Date postCreateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no", nullable = false)
    private User userNo;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes; // 좋아요 리스트 추가

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comment; // 댓글 리스트 추가

    public int getPostLikes() {
        return likes != null ? likes.size() : 0;
    }

    // Date를 연, 월, 일 형식으로 받아오기
    public String getFormattedPostCreateDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 원하는 형식
        return sdf.format(postCreateDate);
    }

    private Integer likeCount; // Integer로 선언

    public Integer getLikeCount() {
        return likeCount; // null일 수 있으므로 Integer로 반환
    }

    public void setLikeCount(int count) {
        this.likeCount = count;
    }
}
