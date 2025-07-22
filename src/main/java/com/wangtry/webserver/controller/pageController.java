package com.wangtry.webserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class pageController {
    @GetMapping("/index")
    public String index() { 
        return "index"; 
    }
}
