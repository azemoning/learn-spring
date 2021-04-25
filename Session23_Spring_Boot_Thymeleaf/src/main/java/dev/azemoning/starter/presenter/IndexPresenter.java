package dev.azemoning.starter.presenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPresenter {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }
}
