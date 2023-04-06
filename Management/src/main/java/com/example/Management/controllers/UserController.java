package com.example.Management.controllers;

import com.example.Management.entities.Role;
import com.example.Management.entities.User;
import com.example.Management.services.UserService;
import com.example.Management.services.UserValidatorService;
import com.example.Management.validators.userValidator.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidatorService userValidatorService;

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration/save")
    public String registerUser(User user) {
        userValidatorService.executeUser(user);
        user.setRole(Role.USER.name());
        userService.save(user);
        return "redirect:/loginApp";
    }

    @GetMapping("/loginApp")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/loginApp/process")
    public String login(User user) {
        if (userService.isLogged(user)) {
            return "redirect:/students";
        } else {
            return "redirect:/loginApp?error";
        }
    }
}
