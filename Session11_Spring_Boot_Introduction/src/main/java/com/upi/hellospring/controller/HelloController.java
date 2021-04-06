package com.upi.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/country")
    public String[] getHello() {
        return new String[]{"Indonesia", "Malaysia", "Thailand", "Filipina", "Laos"};
    }
}
