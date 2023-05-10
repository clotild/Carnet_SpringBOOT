package com.example.carnet.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UnsecuredWebController {
    @GetMapping("/")
    public String home(Model model) {
        return "connexion";
    }
}
