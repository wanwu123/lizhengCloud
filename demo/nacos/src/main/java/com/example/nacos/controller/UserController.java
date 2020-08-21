package com.example.nacos.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/config")
@RefreshScope
public class UserController {


    @RequestMapping("/get")
    public boolean get() {
        return true;
    }
}