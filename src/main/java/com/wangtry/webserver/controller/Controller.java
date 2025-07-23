package com.wangtry.webserver.controller;

import com.wangtry.webserver.service.*;
import org.springframework.web.bind.annotation.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import org.json.*;

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
    @GetMapping("/donate")
    public String payWbank() {
       try {
        String reqUrl = profile.getWbankCardUrl();
        JSONObject json = new JSONObject(profile.getWbankObject());
        URL url = new URL(reqUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PATCH");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        try (OutputStream os = conn.getOutputStream();) { os.write(json.toString().getBytes()); }
        
        int statusCode = conn.getResponseCode();
        if (statusCode == 200) {
            return "success";
        } else {
            return "Not success";
        }
    } catch (Exception e) { return "Error= "+ e.getMessage(); }
    }
}