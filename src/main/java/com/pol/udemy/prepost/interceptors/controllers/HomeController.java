package com.pol.udemy.prepost.interceptors.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> json = new HashMap<String, Object>() {
            {
                put("message", "Welcome to the home page");
                put("status", "200");
            }
        };
        return json;
    }

}
