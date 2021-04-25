package com.yk.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController{
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put(null,"a");
        map.put(null,"d");
        System.out.println(map.get(null));
    }
}