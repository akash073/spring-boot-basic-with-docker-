package com.company.controller;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
@TestPropertySource(locations = {"classpath:application-test.properties"})
public class IndexControllerTest {


    /*@MockBean
    private ModelMapper modelMapper;*/


    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setupMock() {
        /*Mockito.when(modelMapper)
                .thenReturn(new ModelMapper());*/
    }

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
    public void indexTest_RETURN_HELLO() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/index").accept(
                MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect( status().isOk() )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
               // .andExpect(MockMvcResultMatchers.jsonPath("$").equals("index"));
    }

    @Test
    public void indexNotTest() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/index_not").accept(
                MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect( status().isNotFound() ).andReturn();
    }
}
