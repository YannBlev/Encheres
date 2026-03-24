package org.eni.encheres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexRedirectController {

    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:/encheres";
    }
}
