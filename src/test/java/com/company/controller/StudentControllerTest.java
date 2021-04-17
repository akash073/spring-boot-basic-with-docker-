package com.company.controller;


import com.company.Main;
import com.company.entity.Student;
import com.company.repository.StudentRepository;
import com.company.validation.CustomValidator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@ContextConfiguration(classes= Main.class)
@WebMvcTest(StudentController.class)
@TestPropertySource(locations = {"classpath:application-test.properties"})
public class StudentControllerTest {


    @MockBean
    StudentRepository studentRepository;

    @MockBean
    CustomValidator customValidator;

    @MockBean
    ModelMapper modelMapper;



    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() {
        System.out.println("Hello, World !");
    }

    @Test
    public void get_student_list() throws Exception
    {
        Student student = new Student();
        student.setId(1);
        student.setName("akash");

        List<Student> students = Arrays.asList(student);

        Mockito.when(studentRepository.getStudentsByHql()).thenReturn(students);
        Mockito.when(studentRepository.findAll()).thenReturn(students);

        mockMvc.perform( MockMvcRequestBuilders
                .get("/student/list")
                .accept(MediaType.APPLICATION_JSON))
               // .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.students").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.students[*].id").isNotEmpty());

    }

    @Test
    public void get_single_student_id_1() throws Exception
    {
        Student student = new Student();
        student.setId(1);
        student.setName("akash");

        Mockito.when(studentRepository.findById(1)).thenReturn(Optional.of(student));

        mockMvc.perform( MockMvcRequestBuilders
                .get("/student/student-by-id/1")
                .accept(MediaType.APPLICATION_JSON))
              //  .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").isNotEmpty());

    }



}

