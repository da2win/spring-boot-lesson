package com.da2win.springbootlesson19.spring.boot.web.mvc;

import com.da2win.springbootlesson19.configuration.PersonConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author Darwin
 * @Date 2018/11/10 11:06
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@Import(PersonConfiguration.class)
public class PersonControllerSpringBootTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testPerson() throws Exception {
        mvc.perform(get("/person").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
