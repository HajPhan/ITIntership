package com.example.ToeicOnline.repository;

import com.example.ToeicOnline.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findUserByUsername(String name);

    @Query(value = "select *from user where username = ?1 or mail = ?1", nativeQuery = true)
    UserEntity findUserByUsernameOrMail(String username);


//    Error (Table 'toeiconline.user_entity' doesn't exist)
//    UserEntity findUserEntityByUsernameOrMail(String orUsername, String orMail);

}
