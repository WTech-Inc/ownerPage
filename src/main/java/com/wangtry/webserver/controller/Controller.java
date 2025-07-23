package com.wangtry.webserver.controller;

import com.wangtry.webserver.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import java.io.*;
import org.json.*;

@RestController
public class Controller {
    private final ownerProfile profile;
    @Autowired
    private RestTemplate restTemplate;

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
    public ResponseEntity<Map> payWbank() {
       try {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String reqUrl = profile.getWbankCardUrl();
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(profile.getWbankObject(), headers);
        ResponseEntity<Map> response = restTemplate.exchange(reqUrl, HttpMethod.PATCH, request, Map.class);
        return ResponseEntity
               .status(response.getStatusCode())
               .body(response.getBody());
    } catch (Exception e) { 
        Map<String, Object> err = new HashMap<>();
        err.put("error",e.getLocalizedMessage());
        return ResponseEntity
               .internalServerError()
               .body(err);
     }
    }
}