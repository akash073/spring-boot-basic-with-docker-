package com.company.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(){
       // List<Student> students = studentRepository.findAll();
        return "index";
    }

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String hello(){
        return "index";
    }
}
