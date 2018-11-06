package com.da2win.springbootlesson17.controller;

import com.da2win.springbootlesson17.jmx.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Darwin
 * @Date 2018/11/6 16:29
 */
@RestController
public class JMXController {

    @Autowired
    private SimpleBean simpleBean;

    @GetMapping("/jmx/simple-bean")
    public SimpleBean getSimpleBean(@RequestParam(required = false) Long id,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) Integer age) {
        if (id != null) {
            simpleBean.setId(id);
        }
        if (name != null) {
            simpleBean.setName(name);
        }
        if (age!=null) {
            simpleBean.setAge(age);
        }
        return simpleBean;
    }
}
