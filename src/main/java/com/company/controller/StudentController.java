package com.company.controller;

import com.company.constant.MessageEnum;
import com.company.dto.StudentDto;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.mapper.StudentMapper;
import com.company.repository.StudentRepository;
import com.company.response.base.ListResponse;
import com.company.response.base.SuccessResponse;
import com.company.validation.groups.UpdateOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    @GetMapping("list")
    public ListResponse<List<Student>> list(){

        List<Student> students = studentRepository.getStudentsByHql();

        return new ListResponse<>(students,Student.class);
    }

    @GetMapping("{id}")
  //  @RequestMapping(path = "/student-by-id/{studentId}",method = RequestMethod.GET)
    public SuccessResponse<Student> retrieveCoursesForStudent(@PathVariable Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ValidationException(String.format("Student Id %s Not found",id) ));

        return new SuccessResponse<>(student, MessageEnum.OBJECT_FETCHED_SUCCESSFULLY.getValue());
    }

    @PostMapping
   // @RequestMapping(path = "/save",method = RequestMethod.POST)
    public SuccessResponse<Student> save(@RequestBody @Validated StudentDto studentDto) {

        Student student = studentMapper.getStudent(studentDto);

        Student savedStudent = studentRepository.save(student);

        return new SuccessResponse<>(savedStudent,MessageEnum.SAVE_SUCCESSFULLY.getValue());
    }

    //@RequestMapping(path = "/update/{studentId}",method = RequestMethod.PUT)
    @PutMapping("{id}")
    public SuccessResponse<Student> update(@RequestParam Integer id,@Validated({UpdateOperation.class}) @RequestBody StudentDto studentDto) {
/*
        Integer studentId = studentDto.getId();

        if(studentId == null || studentId == 0){
            throw new ValidationException("StudentId can not be null");
        }*/
       // Integer studentId = studentDto.getId();

        studentRepository.findById(id)
                .orElseThrow(() -> new ValidationException(String.format("Student Id %s Not found",id) ));

        Student updatedStudent = null;// modelMapper.map(studentDto,Student.class);

       // studentRepository.save(updatedStudent);


        return new SuccessResponse<>(updatedStudent,MessageEnum.UPDATE_SUCCESSFULLY.getValue());
    }

    //@RequestMapping(path = "/student-by-id/{studentId}",method = RequestMethod.DELETE)
    @DeleteMapping("{id}")
    public SuccessResponse<Student> delete(@PathVariable Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ValidationException(String.format("Student Id %s Not found",id) ));

        studentRepository.delete(student);
        return new SuccessResponse<>(student,MessageEnum.DELETED_SUCCESSFULLY.getValue());
    }

}
