package com.company.controller;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
@TestPropertySource(locations = {"classpath:application-test.properties"})
public class IndexControllerTest {




    @Autowired
    private MockMvc mockMvc;

    @Test
    public void indexTest() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andDo(print()).andReturn();
        String response = result.getResponse().getContentAsString();

        Assertions.assertThat(response).isEqualTo("index");


    }

    @Test
    public void indexNotTest() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/index_not").accept(
                MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect( status().isNotFound() ).andReturn();
    }
}
