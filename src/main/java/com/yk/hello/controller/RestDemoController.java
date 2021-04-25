package com.yk.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class RestDemoController {

    @RequestMapping(path = {"/rest/demo1","/rest/demo2"})
    @ResponseBody
    public String demo1(){
        return "<html><body>hello yk !!!</body></html>";
    }
}
