package com.chungchun.website.course.common;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
