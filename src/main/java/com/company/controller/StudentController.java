package com.company.controller;

import com.company.constant.MessageEnum;
import com.company.dto.StudentDto;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.repository.StudentRepository;
import com.company.response.base.ArrayResponse;
import com.company.response.base.SuccessResponse;
import com.company.validation.CustomValidator;
import com.company.validation.groups.UpdateOperation;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
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

        return new ArrayResponse("students",students,MessageEnum.LIST_FETCHED_SUCCESSFULLY.getValue());
    }

    @RequestMapping(path = "/student-by-id/{studentId}",method = RequestMethod.GET)
    public SuccessResponse<Student> retrieveCoursesForStudent(@PathVariable Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ValidationException(String.format("Student Id %s Not found",studentId) ));

        return new SuccessResponse<>(student, MessageEnum.OBJECT_FETCHED_SUCCESSFULLY.getValue());
    }

    @RequestMapping(path = "/save",method = RequestMethod.POST)
    public SuccessResponse<Student> save(@RequestBody @Validated StudentDto studentDto) {

        Integer studentId = studentDto.getId();


        String name = studentDto.getName();
        if(customValidator.nullOrEmpty(name)){
            throw new ValidationException("Name is empty");
        }

        String mobileNumber = studentDto.getMobile();
        if(!customValidator.mobileValidate(mobileNumber)){
            throw new ValidationException("Mobile number is invalid");
        }

        String email = studentDto.getEmail();
        if(!customValidator.emailValidate(email)){
            throw new ValidationException("Email is invalid");
        }

        Student student = modelMapper.map(studentDto,Student.class);

        Student savedStudent = studentRepository.save(student);

        return new SuccessResponse<>(savedStudent,MessageEnum.SAVE_SUCCESSFULLY.getValue());
    }

    @RequestMapping(path = "/update",method = RequestMethod.PUT)
    public SuccessResponse<Student> update(@Validated({UpdateOperation.class}) @RequestBody StudentDto studentDto) {
/*
        Integer studentId = studentDto.getId();

        if(studentId == null || studentId == 0){
            throw new ValidationException("StudentId can not be null");
        }*/
        Integer studentId = studentDto.getId();

        studentRepository.findById(studentId)
                .orElseThrow(() -> new ValidationException(String.format("Student Id %s Not found",studentId) ));

        Student updatedStudent = modelMapper.map(studentDto,Student.class);

        studentRepository.save(updatedStudent);


        return new SuccessResponse<>(updatedStudent,MessageEnum.UPDATE_SUCCESSFULLY.getValue());
    }

    @RequestMapping(path = "/student-by-id/{studentId}",method = RequestMethod.DELETE)
    public SuccessResponse<Student> delete(@PathVariable Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ValidationException(String.format("Student Id %s Not found",studentId) ));

        studentRepository.delete(student);
        return new SuccessResponse<>(student,MessageEnum.DELETED_SUCCESSFULLY.getValue());
    }

}
