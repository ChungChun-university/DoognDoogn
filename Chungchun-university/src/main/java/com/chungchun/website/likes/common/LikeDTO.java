package com.chungchun.website.likes.common;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LikeDTO {

    private LocalDate c_date;

    private LocalDate d_date;
}
