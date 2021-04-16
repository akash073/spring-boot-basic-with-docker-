package com.company;

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
        System.out.println("Test");

        /*Student student = new Student();
        student.setName("Akash");
        student.setMobile("01719461643");
        student.setEmail("akash073@gmail.com");
        studentRepository.save(student);*/

        List<Student> studentList = studentRepository.findAll();


        return "index";
    }

    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public String hello(){
        System.out.println("Test");
        return "hello";
    }
}
