package com.yk.hello.controller;


import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class UserRepostory {

    @GET
    public String hello(){
        String result = "success";

        return result;
    }
}
