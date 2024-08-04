package com.chungchun.website.course.common;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DTO {

    private int cl_no;

    private String cl_name;

    private LocalDate open_date;

    private LocalDate close_date;
}
