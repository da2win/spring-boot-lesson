package com.da2win.springbootlesson4.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspDemoController {

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("message", "da2win");
        return "index";
    }
}
