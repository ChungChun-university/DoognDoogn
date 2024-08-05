package com.chungchun.website.myclass.common;

import com.chungchun.website.course.common.Course;
import com.chungchun.website.user.common.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="cc_my_class")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class MyClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mc_no")
    private int mcNo;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User userNo;

    @ManyToOne
    @JoinColumn(name = "cls_no")
    private Course clsNo;

    @Column(name = "score")
    private int score;

    @Column(name = "add_count")
    private int addCount;
}
