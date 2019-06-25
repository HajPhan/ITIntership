package com.example.ToeicOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping(value = "/full-test")
    public String fullTest(Model model){
        return "/user/full-test-page";
    }
}
