package com.example.ToeicOnline.repository;

import com.example.ToeicOnline.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository  extends CrudRepository<UserRole,Integer> {
    @Query(value = "SELECT r.name FROM user_role ur JOIN role r WHERE ur.role_id = r.roleid AND ur.user_id = ?1",nativeQuery = true)
    List<String> findNameRoleByUserId(long id);
}
