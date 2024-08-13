package com.chungchun.website.user.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private Integer userNo;
    private String userId;
    private String userPwd;
    private String userName;
    private String userPhone;
    private String role;

    public String getPassword() {
        return userPwd;
    }
}
