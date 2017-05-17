package com.fx.login.entity;

/**
 * Created by hlwang on 2017/5/17.
 */
public class UserEntity {

    public Long id;

    public String userName;

    public String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
