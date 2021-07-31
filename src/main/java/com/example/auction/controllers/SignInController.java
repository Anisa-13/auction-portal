package com.example.auction.controllers;

import com.example.auction.domain.User;
import com.example.auction.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SignInController {
    protected final UserService userService;

    public SignInController(final UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin(ModelMap model) {
        model.addAttribute("user", new User());
        return "signIn";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult result, ModelMap model) {
        model.addAttribute("user", user);
        // save employee to database
        if (result.hasErrors()) {
            return "signIn";
        }
        userService.saveUser(user);
        return "redirect:/";

    }

}
