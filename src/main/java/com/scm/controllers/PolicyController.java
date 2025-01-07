package com.scm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PolicyController {

    // Handle the request for displaying the policy content page
    @GetMapping("/policy")
    public String getPolicyPage(Model model) {
        // Sample static policy content
        String policyTitle = "Privacy Policy";
        String policyContent = "This is the privacy policy content for your website. It outlines the data usage, collection, and privacy practices.";

        // Add the content and title to the model to display it on the policy page
        model.addAttribute("policyTitle", policyTitle);
        model.addAttribute("policyContent", policyContent);

        // Return the Thymeleaf view to render the policy page
        return "policy";
    }
}

