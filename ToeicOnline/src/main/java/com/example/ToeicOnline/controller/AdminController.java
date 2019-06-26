package com.example.ToeicOnline.controller;

import com.example.ToeicOnline.model.UserEntity;
import com.example.ToeicOnline.service.UserService;
import com.example.ToeicOnline.utils.PasswordEncrytedUtils;
import com.example.ToeicOnline.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String login() {
        return "/admin/page-login";
    }

    @RequestMapping(value = "/logout")
    public String logoutSuccess(Model model) {
        return "redirect:/login?message=logout";
    }

    @RequestMapping(value = "/forget")
    public String forget(Model model) {
        return "/admin/page-forget";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new UserEntity());
        return "/admin/page-register";
    }

    @RequestMapping(value = "/save-user", method = RequestMethod.POST)
    public String saveUser(Model model, @ModelAttribute UserEntity entity) {
        boolean check = false;
        UserEntity userMail = this.userService.getUserByUsernameOrMail(entity.getMail());
        UserEntity userName = this.userService.getUserByUsernameOrMail(entity.getUsername());

        if (userMail != null) {
            if (userName != null) {
                return "redirect:/register?message=error-user";
            } else {
                return "redirect:/register?message=error-mail";
            }
        }
        entity.setPassword(PasswordEncrytedUtils.encoder(entity.getPassword()));
        entity.setCreateddate(Timestamp.valueOf(LocalDateTime.now()));
        check = this.userService.saveUser(entity);
        if (check == true) {
            return "redirect:/register?message=success";
        } else {
            return "redirect:/register?message=error";
        }
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
        User user = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(user);
//        model.addAttribute("userInfo", userInfo);
//        model.addAttribute("userList", this.userService.getAllUser());
        return "/admin/admin-page";
    }


}
