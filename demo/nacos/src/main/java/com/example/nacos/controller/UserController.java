package com.example.nacos.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Launcher;

import java.net.URL;
import java.net.URLClassLoader;


@RestController
@RequestMapping("/config")
@RefreshScope
public class UserController {


    @RequestMapping("/get")
    public boolean get() {

        return true;
    }

    public static void main(String[] args) {
        String[] urls = System.getProperty("java.class.path").split(":");

        for (String url : urls) {
            System.out.println(url);
        }

        System.out.println("================================");

        URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();

        URL[] urls1 = classLoader.getURLs();
        for (URL url : urls1) {
            System.out.println(url);
        }
    }
}