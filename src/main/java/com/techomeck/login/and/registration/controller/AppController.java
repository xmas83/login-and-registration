package com.techomeck.login.and.registration.controller;


import com.techomeck.login.and.registration.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user",new User());
        return "signup_form";
    }
}
