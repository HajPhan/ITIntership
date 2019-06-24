package com.example.ToeicOnline.repository;

import com.example.ToeicOnline.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

    UserEntity findUserByName(String name);

}
