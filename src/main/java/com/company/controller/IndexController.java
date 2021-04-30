package com.company.controller;

import com.company.dto.LoginDto;
import com.company.dto.StudentDto;
import com.company.entity.Student;
import com.company.mapper.StudentMapper;
import com.company.response.base.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/**
 * https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-springdoc-openapi-3/
* */
@RestController
@RequiredArgsConstructor
@Tag(name = "contact", description = "the Contact API")
public class IndexController {


    private final MessageSource messageSource;

    private final StudentMapper studentMapper;




    @Operation(summary = "Find Contacts by name", description = "Name search by %name% format", tags = { "contact" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = StudentDto.class)))) })

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public SuccessResponse<Student> index(@RequestHeader(name = "Accept-Language", required = false, defaultValue = "fr") String localeString, HttpServletRequest httpServletRequest) {
        // List<Student> students = studentRepository.findAll();


        Student student  = new Student();
        student.setId(1);
        student.setName("AKASH");

        //StudentDto studentDto = studentMapper.getEntityFromModel(student);

        //System.out.println(studentDto);

        LoginDto loginDto = LoginDto.builder()
                .loginName("akashn").password("passeord")

                .build();





        int i = 0;


       /* if(student !=null){
            throw new ValidationException("good.morning.message");
        }*/


        //LoginDto test = modelMapper.addMappings(studentFromLoginDtoConverter).map(student);


//        System.out.println(student);

       // GenericClass genericClass = new GenericClass(student);

        List<Student> students = Arrays.asList(student);
        //List<Student> students = new ArrayList<>();

        //return new GenericClass<List<Student>>(students,Student.class);

        Student emTy = new Student();

       // return new ListResponse<List<Student>>(students,Student.class,"My message");

        return new SuccessResponse<Student>(student);
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
