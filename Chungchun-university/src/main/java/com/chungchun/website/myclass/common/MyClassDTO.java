package com.chungchun.website.myclass.common;

import jakarta.persistence.Column;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MyClassDTO {

    private int mc_no;

    private int user_no;

    private int cl_no;

    private int score;

    private int add_count;


}
