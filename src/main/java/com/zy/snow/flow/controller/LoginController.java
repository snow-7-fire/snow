package com.zy.snow.flow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zengyan
 * @Date: 2020-06-17 00:18
 */
@RestController
public class LoginController {

    @RequestMapping("/hello")
    public String hello(){
        return "sucecss";
    }
}
