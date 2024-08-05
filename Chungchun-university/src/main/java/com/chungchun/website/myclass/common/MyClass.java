package com.chungchun.website.myclass.common;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="myClass")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class MyClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mc_no")
    private int mc_no;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user_no;

    @ManyToOne
    @JoinColumn(name = "cl_no")
    private Course cl_no;

    @Column(name = "score")
    private int score;

    @Column(name = "add_count")
    private int add_count;
}
