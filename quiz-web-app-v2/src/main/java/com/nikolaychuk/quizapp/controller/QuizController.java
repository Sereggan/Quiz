package com.nikolaychuk.quizapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class QuizController {

    @GetMapping
    public String homePage(Model model){
        model.addAttribute("name", "Sergey");

        return "home"; //view
    }
}
