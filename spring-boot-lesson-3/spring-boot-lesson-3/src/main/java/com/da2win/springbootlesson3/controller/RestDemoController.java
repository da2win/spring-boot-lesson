package com.da2win.springbootlesson3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class RestDemoController {

    // HTML
    @RequestMapping(path = {"/html/demo", "/html/demo2"})
    @ResponseBody
    public String htmlCode() {
        return "<html><body>Hello world</body></html>";
    }

    // HTML
    @RequestMapping(path = "/html/demo/response/entity")
    public ResponseEntity<String> responseEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("myHeader", Arrays.asList("myHeaderValue"));
        ResponseEntity responseEntity = new ResponseEntity<String>("<html><body>HTML response entity</body></html>", headers, HttpStatus.OK);
        return responseEntity;
    }
}
