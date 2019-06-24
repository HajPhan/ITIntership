package com.example.ToeicOnline.service;

import com.example.ToeicOnline.model.UserEntity;
import com.example.ToeicOnline.repository.UserRepository;
import com.example.ToeicOnline.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = this.userRepository.findUserByName(username);

        if (user == null) {
            System.err.println("User not found!");
            throw new UsernameNotFoundException("User + " + username + " was not found in the database");
        }

        System.err.println("Found User = " + username);

        // get Role Id by user id
        List<String> roleName = this.userRoleRepository.findNameRoleByUserId(user.getUserid());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (grantList != null) {
            for (String role : roleName) {
                GrantedAuthority auth = new SimpleGrantedAuthority(role);
                grantList.add(auth);
                System.err.println("role = " + role);
            }
        }

        UserDetails userDetails = new User(user.getName(), user.getPassword(), grantList);
        return userDetails;
    }
}
