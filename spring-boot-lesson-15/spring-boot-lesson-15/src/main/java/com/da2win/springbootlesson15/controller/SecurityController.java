package com.da2win.springbootlesson15.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/xss")
    public String xss(Model model) {
        // JS Code 需要被 escape
        model.addAttribute("jsCode", "<script>alert('XSS Attack')</script>");
        // HTML code 不需要被 escape(Unescape)
        model.addAttribute("htmlCode", "<span>Hello world</span>");
        return "xss";
    }
}
