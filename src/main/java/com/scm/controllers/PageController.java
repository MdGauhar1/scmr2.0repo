package com.scm.controllers;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

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

// showing register page
    @RequestMapping("/register")
    public String registerPage(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }


//processing register
    @RequestMapping(value ="/do-register", method=RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session) {


        if (rBindingResult.hasErrors()){
            return "register";
        }
        //validate
        //save ti database
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic(
                "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75");

        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        //add message for sucessfull or faliur
        // Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        Message message = new Message("Registration Successful", MessageType.green);
        session.setAttribute("message",message);

        //redirect
        return "redirect:/register";
    }

}