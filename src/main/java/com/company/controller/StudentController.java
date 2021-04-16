package com.company.controller;

import com.company.dto.StudentDto;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.repository.StudentRepository;
import com.company.response.base.ArrayResponse;
import com.company.response.base.SuccessResponse;
import com.company.validation.CustomValidator;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Api(value = "student", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"student-details"}, description = "Student info")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CustomValidator customValidator;

    @Autowired
    ModelMapper modelMapper;


    @RequestMapping(path = "/list",method = RequestMethod.GET)
    public ArrayResponse<Student> list(){

        List<Student> students = studentRepository.getStudentsByHql();

        return new ArrayResponse("students",students,"List fetched successfully");
    }

    @RequestMapping(path = "/student-by-id/{studentId}",method = RequestMethod.GET)
    public SuccessResponse<Student> retrieveCoursesForStudent(@PathVariable Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ValidationException(String.format("Student Id %s Not found",studentId) ));

        return new SuccessResponse<>(student,"Student fetched successfully");
    }

    @RequestMapping(path = "/save",method = RequestMethod.POST)
    public SuccessResponse<Student> save(@RequestBody StudentDto studentDto) {


        Student student = modelMapper.map(studentDto,Student.class);

        return new SuccessResponse<>(student,"Student created successfully");
    }

    @RequestMapping(path = "/update",method = RequestMethod.PUT)
    public SuccessResponse<Student> update(@RequestBody StudentDto studentDto) {


        Student student = modelMapper.map(studentDto,Student.class);

        return new SuccessResponse<>(student,"Student created successfully");
    }

    @RequestMapping(path = "/student-by-id/{studentId}",method = RequestMethod.DELETE)
    public SuccessResponse<Student> delete(@PathVariable Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ValidationException(String.format("Student Id %s Not found",studentId) ));

        studentRepository.delete(student);
        return new SuccessResponse<>(student,"Student fetched successfully");
    }

}
