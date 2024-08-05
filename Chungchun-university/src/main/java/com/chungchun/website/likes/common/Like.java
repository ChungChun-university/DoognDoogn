package com.chungchun.website.likes.common;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="like")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Like {

    @Column(name = "c_date")
    // 생성일자
    private LocalDate c_date;

    @Column(name = "d_date")
    private LocalDate d_date;

    @ManyToOne
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_no", nullable = false)
    private Post post;



}
