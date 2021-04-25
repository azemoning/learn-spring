package dev.azemoning.starter.presenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPresenter {

    @GetMapping("login")
    public String showLogin() {
        return "login";
    }
}
