package com.scm.controllers;

import com.scm.entities.User;
import com.scm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // user dashbaord page

    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        System.out.println("User dashboard");
        return "user/dashboard";
    }

    // user profile page

    @RequestMapping(value = "/profile")
    public String userProfile(Model model, Authentication authentication) {
        String user = authentication.getName();

         //Get additional user details from your User entity (if needed)
        User userName = (User) authentication.getPrincipal(); // assuming you're using a custom UserDetailsService

        // Add the user details to the model
        model.addAttribute("username", userName.getName()); // if you want to display their full name

         //Display welcome message with username
        System.out.println("Welcome"+ userName.getName()); // or use the username/email

        return "user/profile";
    }

    // user add contacts page

    // user view contacts

    // user edit contact

    // user delete contact

}
