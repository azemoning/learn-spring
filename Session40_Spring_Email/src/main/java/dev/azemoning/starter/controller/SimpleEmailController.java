package dev.azemoning.starter.controller;

import dev.azemoning.starter.utility.EmailServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SimpleEmailController {

    @Autowired
    private EmailServiceUtil emailServiceUtil;

    @PostMapping("send-email")
    public String sendEmail() {
        emailServiceUtil.sendSimpleMessage("ahmadsaufimaulana@gmail.com",
                "Hello, World!",
                "Testing 1 2 3...");
        return "Email sent";
    }
}
