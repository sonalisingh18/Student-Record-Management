package com.sonali.srm.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Home {

    @GetMapping
    public String home() {
        return "Welcome to Student Record Management Application!! "+new Date();
    }
}