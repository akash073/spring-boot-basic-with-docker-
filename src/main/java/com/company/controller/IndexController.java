package com.company.controller;

import com.company.dto.LoginDto;
import com.company.entity.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class IndexController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ModelMapper modelMapper;


    private PropertyMap<LoginDto, Student> studentFromLoginDtoConverter = new PropertyMap<LoginDto, Student>() {
        protected void configure() {
            //map().setId(source.getId());
            map().setName(source.getLoginName());
            map().setEmail(source.getPassword());
        }
    };


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        // List<Student> students = studentRepository.findAll();

        LoginDto loginDto = LoginDto.builder()
                .loginName("akashn").password("passeord")
                .build();

        Student student =
                modelMapper.addMappings(studentFromLoginDtoConverter).map(loginDto);


        //LoginDto test = modelMapper.addMappings(studentFromLoginDtoConverter).map(student);


        System.out.println(student);
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
