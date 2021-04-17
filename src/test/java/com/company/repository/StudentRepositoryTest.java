package com.company.repository;

import com.company.entity.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


/*
https://stackoverflow.com/questions/40064988/cant-autowire-jparepository-in-junit-test-spring-boot-application
* */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableConfigurationProperties
@TestPropertySource(locations = {"classpath:application-test.properties"})
public class StudentRepositoryTest {


    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void jpa_reposioty_test() throws Exception {

        Student student = new Student();
        student.setName("No null");

        Student updated_student  = studentRepository.save(student);

        List<Student> students = studentRepository.findAll();

        Assertions.assertThat(students).isNotNull();
        Assertions.assertThat(students.size()).isEqualTo(1);



        String mobile_no = "01719461643";
        updated_student.setMobile(mobile_no);

        studentRepository.save(updated_student);

        Student student1 = studentRepository.findById(updated_student.getId()).orElse(null);

        Assertions.assertThat(student1).isNotNull();
        Assertions.assertThat(student1.getMobile()).isEqualTo(mobile_no);


        studentRepository.delete(updated_student);


        students = studentRepository.getStudentsByHql();

        Assertions.assertThat(students).isNotNull();
        Assertions.assertThat(students.size()).isEqualTo(0);








       /* RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/index_not").accept(
                MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect( status().isNotFound() ).andReturn();*/
    }

}
