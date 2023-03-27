package org.spring.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model, @RequestParam(name = "name", required = true) String nameQueryString) {

        model.addAttribute("name", nameQueryString);
        return "home";
    }

}
