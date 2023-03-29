package com.example.Management.controller;

import com.example.Management.entity.Role;
import com.example.Management.entity.User;
import com.example.Management.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration/save")
    public String registerUser(User user) {
        User existUser = userRepo.findByUsername(user.getUsername());
        User existUser1 = userRepo.findByEmail(user.getEmail());

        if (existUser != null || existUser1 != null) {
            return "redirect:/registration?error";
        }
        user.setPassword(user.getPassword());
        user.setRole(Role.USER.name());
        userRepo.save(user);
        return "redirect:/loginApp";
    }

    @GetMapping("/loginApp")
    public String loginPage() {
        return "login";
    }

//    @GetMapping("/loginApp/process")
//    public String login(User user) {
//        User testUser = userRepo.findByUsername(user.getUsername());
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//        if (testUser != null && (passwordEncoder.matches(user.getPassword(), testUser.getPassword()))) {
//            return "redirect:/students";
//        } else {
//            return "redirect:/loginApp?error";
//        }
//    }
}
