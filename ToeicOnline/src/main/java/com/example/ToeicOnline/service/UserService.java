package com.example.ToeicOnline.service;

import com.example.ToeicOnline.model.UserEntity;

public interface UserService {

    UserEntity getUserByName(String name);

    Iterable<UserEntity> getAllUser();
}
