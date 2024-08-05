package com.chungchun.website.user.common;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private int user_no;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "user_pwd")
    private String user_pwd;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_phone")
    private String user_phone;

    @Column(name = "user_auth")
    private String user_auth;
}
