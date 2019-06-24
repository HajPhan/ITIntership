package com.example.ToeicOnline.service;

import com.example.ToeicOnline.model.UserEntity;
import com.example.ToeicOnline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserByName(String name) {
        return this.userRepository.findUserByName(name);
    }

    @Override
    public Iterable<UserEntity> getAllUser() {
        return this.userRepository.findAll();
    }
}
