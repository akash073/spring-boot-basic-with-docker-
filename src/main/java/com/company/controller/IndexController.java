package com.company.controller;

import com.company.converter.StudentMapper;
import com.company.dto.LoginDto;
import com.company.dto.StudentDto;
import com.company.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class IndexController {


    private final MessageSource messageSource;

    private final StudentMapper studentMapper;





    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(@RequestHeader(name = "Accept-Language", required = false, defaultValue = "fr") String localeString, HttpServletRequest httpServletRequest) {
        // List<Student> students = studentRepository.findAll();


        Student student  = new Student();
        student.setId(1);
        student.setName("AKASH");

        StudentDto studentDto = studentMapper.getEntityFromModel(student);

        System.out.println(studentDto);

        LoginDto loginDto = LoginDto.builder()
                .loginName("akashn").password("passeord")

                .build();



/*

        Student student =
                GenericConverter.mapper(loginDto,Student.class,studentFromLoginDtoConverter);

        if(student !=null){
            throw new ValidationException("good.morning.message");
        }
*/

        //LoginDto test = modelMapper.addMappings(studentFromLoginDtoConverter).map(student);


//        System.out.println(student);
        return "index";
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String hello() {
        return "index";
    }

    //internationalization
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false, defaultValue = "us") String localeString) {
        Locale locale = new Locale(localeString);
        return messageSource.getMessage("good.morning.message", null, locale);
    }
}
