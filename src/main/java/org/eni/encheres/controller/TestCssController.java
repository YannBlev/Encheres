package org.eni.encheres.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/encheres")
public class TestCssController {

    @GetMapping("/test")
    public String test(){
        return "/page/test";
    }
}
