package com.example.ToeicOnline.service;

import com.example.ToeicOnline.model.UserEntity;

public interface UserService {

    boolean saveUser(UserEntity entity);

    UserEntity getUserByUsernameOrMail(String mail);

    Iterable<UserEntity> getAllUser();
}
