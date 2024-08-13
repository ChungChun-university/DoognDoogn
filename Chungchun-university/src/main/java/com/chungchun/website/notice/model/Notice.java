package com.chungchun.website.notice.model;

import com.chungchun.website.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="cc_notice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noti_no")
    private int noticeNo;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @Column(name = "noti_title")
    private String noticeTitle;

    @Column(name = "noti_content")
    private String noticeContent;

    @Column(name = "noti_create_date")
    private LocalDate noticeCreateDate;

    @Column(name = "noti_up_date")
    private LocalDate noticeUpDate;
}
