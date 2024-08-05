package com.chungchun.website.notice.common;

import com.chungchun.website.user.common.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="notice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noti_no")
    private int noti_no;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user_no;

    @Column(name = "noti_title")
    private String noti_title;

    @Column(name = "noti_content")
    private String noti_content;

    @Column(name = "noti_cdate")
    private LocalDate noti_cdate;

    @Column(name = "noti_udate")
    private LocalDate noti_udate;
}
