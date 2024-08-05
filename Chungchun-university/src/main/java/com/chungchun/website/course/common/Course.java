package com.chungchun.website.course.common;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_no", nullable = false)
    private int cl_no;

    @Column(name = "cl_name", nullable = false)
    private String cl_name;

    @Column(name = "open_date", nullable = false)
    private LocalDate open_date;

    @Column(name = "close_date", nullable = false)
    private LocalDate close_date;

    @Column(name = "cl_intro", nullable = false)
    private String cl_intro;

    @Column(name = "cl_prof", nullable = false)
    private String cl_prof;

    @ManyToOne
    @JoinColumn(name = "user_no", nullable = false)
    private User user;






}
