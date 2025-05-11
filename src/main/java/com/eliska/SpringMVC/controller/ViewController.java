package com.eliska.SpringMVC.controller;

import com.eliska.SpringMVC.SpringMvcApplication;
import com.eliska.SpringMVC.service.ArticleService;
import com.eliska.SpringMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
    //Dependency Injection
    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;


    //GET mapping - pro zobrazeni stranky
    @GetMapping("/")
    public ModelAndView mainPage() {

        ModelAndView modelAndView = new ModelAndView("index"); //namapovani sablony index.html

        modelAndView.addObject("allUsers", userService.findAll()); //namapovani allUsers do sablony index.html
        modelAndView.addObject("allArticles", articleService.getAllArticles()); //namapovani allUsers do sablony index.html

        return modelAndView;
    }
}
