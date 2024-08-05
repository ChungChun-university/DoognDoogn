package com.chungchun.website.notice.common;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NoticeDTO {
    private int noti_no;

    private User user_no;

    private String noti_title;

    private String noti_content;

    private LocalDate noti_cdate;

    private LocalDate noti_udate;

}
