package com.company.controller;

import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.repository.StudentRepository;
import com.company.validation.CustomValidator;
import com.google.common.base.VerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CustomValidator customValidator;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(){
        System.out.println("Test");

        String name = "";

        if(customValidator.nullOrEmpty(name)){
            throw new ValidationException("User Name is empty");
        }


        /*Student student = new Student();
        student.setName("Akash");
        student.setMobile("01719461643");
        student.setEmail("akash073@gmail.com");
        studentRepository.save(student);*/




        List<Student> studentList = studentRepository.findAll();

        if(studentList.size() == 1){
            throw new VerifyException("Student list of size 1");
        }

        List<Student> students = studentRepository.getStudentsByHql();
        System.out.println(students);


        return "index";
    }

    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public String hello(){
        System.out.println("Test");
        return "hello";
    }
}
