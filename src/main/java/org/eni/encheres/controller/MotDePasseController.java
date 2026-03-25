package org.eni.encheres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/encheres")
public class MotDePasseController {

    @GetMapping("/forgotPassword")
    public String showForgotPasswordForm() {
        return "encheres/motDePasse";
    }

    @PostMapping("/forgotPassword")
    public String handleForgotPassword() {
        return "/login";
    }
}
