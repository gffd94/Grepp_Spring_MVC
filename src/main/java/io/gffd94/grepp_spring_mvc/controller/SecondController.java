package io.gffd94.grepp_spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

    @GetMapping("/page-1")
    public String showPage1() {
        return "hello_page";
    }

    @GetMapping("/page-2")
    public String showPage2() {
        return "txt_page";
    }

}
