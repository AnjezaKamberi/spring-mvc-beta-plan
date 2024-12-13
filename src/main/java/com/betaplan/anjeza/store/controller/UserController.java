package com.betaplan.anjeza.store.controller;


import com.betaplan.anjeza.store.model.LoginUser;
import com.betaplan.anjeza.store.model.User;
import com.betaplan.anjeza.store.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login-register")
    public String index(Model model) {
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "login-register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {

        // Call register method in service for extra validations
        userService.validateAndRegister(newUser, result);

        if (result.hasErrors()) {
            // Ensure LoginUser object is passed back to the view
            model.addAttribute("newLogin", new LoginUser());
            return "login-register";
        }

        // Store user ID in session (log them in)
        session.setAttribute("userId", newUser.getId());
        System.out.println("User ID set in session: " + newUser.getId());
        return "redirect:/all-products";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {

        // Authenticate the user using the service
        User user = userService.login(newLogin, result);

        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login-register";
        }

        // Store user ID in session (log them in)
        session.setAttribute("userId", user.getId());
        return "redirect:/all-products";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userId");  // Remove the loggedInUser session attribute
        return "redirect:/all-products";  // Redirect to the landing page
    }
}