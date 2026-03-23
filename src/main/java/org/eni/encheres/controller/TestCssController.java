package org.eni.encheres.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor

public class TestCssController {

    @GetMapping("/test")
    public String test(){
        return "/page/test";
    }
}
