package com.corujito.champz.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Championship {

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }
}
