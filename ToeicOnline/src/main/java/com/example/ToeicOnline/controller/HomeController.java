package com.example.ToeicOnline.controller;

import com.example.ToeicOnline.service.UserService;
import com.example.ToeicOnline.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        String userName = principal.getName();
        System.out.println("User name: " + userName);
        User user = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(user);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("userList", this.userService.getAllUser());
        return "user-page";
    }

    @RequestMapping(value = "/403")
    public String accessDenied(Model model, Principal pirPrincipal) {
        if (pirPrincipal != null) {
            User loginedUser = (User) ((Authentication) pirPrincipal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + pirPrincipal.getName() + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403-page";
    }


}
