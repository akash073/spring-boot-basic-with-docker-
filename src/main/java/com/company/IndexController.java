package com.company;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(){
        System.out.println("Test");
        return "index";
    }

    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public String hello(){
        System.out.println("Test");
        return "hello";
    }
}
