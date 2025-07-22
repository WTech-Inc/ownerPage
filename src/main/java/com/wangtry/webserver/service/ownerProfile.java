package com.wangtry.webserver.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ownerProfile {
    public String getName() { return "wangtry"; }
    public Object getInfo() {
        Map <String, Object> info = new HashMap<>();
        String[] hobbies = { "gym", "making-video", "cutting-video", "coding"};
        info.put("name", "wangtry");
        info.put("age", 18);
        info.put("career", "student");
        info.put("hobbies", hobbies);
        return info;
    }
}