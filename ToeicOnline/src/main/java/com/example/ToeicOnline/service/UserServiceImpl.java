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
    public boolean saveUser(UserEntity entity) {
        this.userRepository.save(entity);
        return true;
    }

    @Override
    public UserEntity getUserByUsernameOrMail(String mail) {
        return this.userRepository.findUserByUsernameOrMail(mail);
    }

    @Override
    public Iterable<UserEntity> getAllUser() {
        return this.userRepository.findAll();
    }
}
