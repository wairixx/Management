package com.example.Management.controllers;

import com.example.Management.entities.Role;
import com.example.Management.entities.User;
import com.example.Management.services.UserService;
import com.example.Management.services.UserValidatorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;


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
        user.setActivated(false);
        user.setActivationCode(UUID.randomUUID().toString());
        userService.save(user);
        userService.sendMassage(user);
        return "/activate";
    }

    @GetMapping("/activate")
    public String activatePage() {
        return "activate";
    }

    @GetMapping("/loginApp")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/loginApp/process")
    public String login(User user) {
        userValidatorService.executeLoginUser(userService.findByUsername(user.getUsername()));
        if (userService.isLogged(user)) {
            return "redirect:/students";
        } else {
            return "redirect:/loginApp?error";
        }
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        if (userService.findByActivationCode(code)) {
            userService.activateUser(code);
            return "redirect:/loginApp";
        }
        return "index";
    }
}
