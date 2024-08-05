package com.chungchun.website.course.common;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@jakarta.persistence.Entity
@Table(name="class")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_no")
    private int cl_no;

    @Column(name = "cl_name")
    private String cl_name;

    @Column(name = "open_date")
    private LocalDate open_date;

    @Column(name = "close_date")
    private LocalDate close_date;

    @Column(name = "cl_intro")
    private String cl_intro;

    @Column(name = "cl_prof")
    private String cl_prof;




}
