package com.company.controller;

import com.company.entity.Student;
import com.company.repository.StudentRepository;
import com.company.response.base.ArrayResponse;
import com.company.response.base.SuccessResponse;
import com.company.validation.CustomValidator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@Api(value = "student", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"student-details"}, description = "Student info")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CustomValidator customValidator;


    @RequestMapping(path = "/list",method = RequestMethod.GET)
    public ArrayResponse<Student> list(){

        List<Student> students = studentRepository.getStudentsByHql();

        return new ArrayResponse("students",students);
    }

}
