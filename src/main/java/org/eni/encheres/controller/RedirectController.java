package org.eni.encheres.controller;

import org.springframework.messaging.handler.annotation.support.MethodArgumentTypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;



@Controller
public class RedirectController {

    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "redirect:/encheres";
    }



    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        // Si l'utilisateur tape "banane" dans l'URL, on l'intercepte ici
        // Et on le redirige gentiment vers la liste des enchères
        return "redirect:/encheres";
    }
}