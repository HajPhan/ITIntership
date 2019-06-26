package com.example.ToeicOnline.controller;

import com.example.ToeicOnline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public String userPage(Model model) {
        return "/user/user-page";
    }

    @RequestMapping(value = "/full-test")
    public String fullTest(Model model) {
        return "/user/full-test-page";
    }

}
