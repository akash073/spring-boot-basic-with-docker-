package com.company.controller;

import com.company.dto.LoginDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(){
       // List<Student> students = studentRepository.findAll();

        LoginDto loginDto = LoginDto.builder()
                .loginName("akashn").password("passeord")
                .build();

        System.out.println(loginDto);
        return "index";
    }

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String hello(){
        return "index";
    }
}
