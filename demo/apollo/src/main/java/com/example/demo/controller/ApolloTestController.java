package com.example.demo.controller;


import com.example.demo.config.ApolloCofig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/a")
public class ApolloTestController {

    @Resource
    private ApolloCofig apolloCofig;

    @GetMapping("a")
    public Object getConfig(@RequestParam("name")String name){
        System.out.println(apolloCofig.getConfig2(name, null));
        return apolloCofig.getConfig(name,null);
    }
}
