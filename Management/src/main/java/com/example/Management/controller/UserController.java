package com.example.Management.controller;

import com.example.Management.entity.Role;
import com.example.Management.entity.User;
import com.example.Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration/save")
    public String registerUser(User user) {

        if (userService.emailIsUsed(user)) {
            return "redirect:/registration?errorEmail";
        } else if (userService.usernameIsUsed(user)) {
            return "redirect:/registration?errorUsername";
        }
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
