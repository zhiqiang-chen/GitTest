package com.example.springbootdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO
 *
 * @author czq
 * @date 2021/6/2 17:11
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String nickname;
    private String regTime;

    public User() {
    }

    public User(String email, String nickname, String password, String userName, String regTime, Long id) {
        super();
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.userName = userName;
        this.regTime = regTime;
        this.id = id;
    }
}
