package com.taskboards.configuration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = ConfigurationApplication.class,
                webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ConfigurationServerIntegrationTest {
	
	@Autowired
    private MockMvc mvc;

    @Test
    public void shouldProvideTheCorrectConfigurationValue() throws Exception {    	
    	mvc.perform(get("/test-configuration-client/default")
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(content()
    		      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
    		      .andExpect(jsonPath("$.propertySources.[0].source.message", is("Working")));
    }
	
}
