package com.company.controller;

import com.company.entity.Student;
import com.company.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(){
        List<Student> students = studentRepository.findAll();
        return "index";
    }

    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
}
