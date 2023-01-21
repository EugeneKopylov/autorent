package it.academy.controller.other;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping({"/", "/index.view"})
    public ModelAndView homePage() {
        System.out.println("Call homePage");
        return new ModelAndView("index");
    }

}