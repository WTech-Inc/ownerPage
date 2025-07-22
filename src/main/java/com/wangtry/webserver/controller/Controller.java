package com.wangtry.webserver.controller;

import com.wangtry.webserver.service.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private final ownerProfile profile;

    public Controller(ownerProfile profile) {
       this.profile = profile;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }
    @GetMapping("/get-info")
    public Object printInfo() {
        return profile.getInfo();
    }
}