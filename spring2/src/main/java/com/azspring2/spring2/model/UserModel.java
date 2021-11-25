package com.azspring2.spring2.model;

import com.azspring2.spring2.entity.UserEntity;

public class UserModel {

    private Long id;
    private String username;

    public static UserModel toModel (UserEntity user){
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setUsername(user.getUsername());

        return userModel;
    }

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }
}
