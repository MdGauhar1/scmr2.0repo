package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("HomeController");
        model.addAttribute("title", "Welcome to the SCM 2.0 Application");
        model.addAttribute("message", "this is a simple application");
        return "home";
    }


//routes
    @RequestMapping("/about")
    public String aboutPage(Model model) {
        System.out.println("this is about pager");
        return "about";
    }
//services

    @RequestMapping("/services")
    public String servicePage(Model model) {
        System.out.println("this is service");
        return "services";
    }

    @RequestMapping("/contact")
    public String contactPage(Model model) {
        System.out.println("this is service");
        model.addAttribute("contact");
        return "contact";
    }

    @RequestMapping("/login")
    public String loginPage(Model model) {
        System.out.println("this is service");
        model.addAttribute("login");
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage(Model model) {
        System.out.println("this is service");
        model.addAttribute("register");
        return "register";
    }


}