package org.eni.encheres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/encheres")
public class MotDePasseController {

    @GetMapping("/motDePasse")
    public String showForgotPasswordForm() {
        return "page/motDePasse";
    }

    @PostMapping("/motDePasse")
    public String handleForgotPassword() {
        return "redirect:/encheres/login";
    }
}
