package org.eni.encheres.controller;

import org.eni.encheres.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    CategorieService categorieService;



}
