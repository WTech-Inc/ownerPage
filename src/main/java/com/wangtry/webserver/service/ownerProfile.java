package com.wangtry.webserver.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ownerProfile {
    public String getName() { return "wangtry"; }
    public String getWbankCardUrl() { return "https://wtechhk.com/wbank/card/action"; }
    public Object getInfo() {
        Map <String, Object> info = new HashMap<>();
        String[] hobbies = { "gym", "making-video", "cutting-video", "coding"};
        info.put("name", "wangtry");
        info.put("age", 18);
        info.put("career", "student");
        info.put("hobbies", hobbies);
        return info;
    }
    public Object getWbankObject() {
        Map <String, String> wbankInfo = new HashMap<>();
        wbankInfo.put("cardNumber", "136ac5102067b800ec5d645e26e80074f44e54b560a3481c856aea0d694c6c49");
        wbankInfo.put("password", "Chan1234!");
        wbankInfo.put("accessKey", "0118");
        wbankInfo.put("reviewer", "wangtry");
        wbankInfo.put("amount", "1000");
        return wbankInfo;
    }
}