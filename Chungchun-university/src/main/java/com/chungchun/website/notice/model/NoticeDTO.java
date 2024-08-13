package com.chungchun.website.notice.model;

import com.chungchun.website.user.model.User;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NoticeDTO {
    private int noticeNo;

    private User user;

    private String noticeTitle;

    private String noticeContent;

    private LocalDate noticeCreateDate;

    private LocalDate noticeUpDate;

}
