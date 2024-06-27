package com.ohgiraffers.notimplement.auth.model.dto;

import groovy.transform.ToString;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
public class UserDTO {
    private String seq;
    private String name;
    private String id;
    private String password;
    private String passwordCheck;
    private String email;
    private String addr;
    private String rrn;
    private String phone;
    private String reg_date;
    private LocalDate update_date;

    public UserDTO(String id) {
        this.id = id;
    }
}



