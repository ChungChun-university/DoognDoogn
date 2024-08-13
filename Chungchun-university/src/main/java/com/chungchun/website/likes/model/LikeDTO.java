package com.chungchun.website.likes.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LikeDTO {

    private LocalDate createDate;

    private LocalDate deleteDate;

    private boolean isLiked; // 추가된 필드
}
