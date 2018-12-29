package com.stocktrainer.stockJb.controllers;

import com.stocktrainer.stockJb.ApplicationTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
public abstract class ControllerTest implements ApplicationTest {

    String endpointUrl;
    String visitUrl;
    String responseBody;
    String requestBody;

    @Autowired
    MockMvc mockController;

    MockHttpServletResponse response;

    abstract void initialize();

    abstract void clearUp();

    MockHttpServletResponse makeGetRequest(String url) throws Exception {
        return mockController.perform(get(url).accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
    }

    MockHttpServletResponse makePostRequest(String url, String requestBody) throws Exception {
        return mockController.perform(post(url)
                .accept(MediaType.APPLICATION_JSON)
                .param("userJson", requestBody))
                .andReturn().getResponse();

    }

    void verifyResponseContent(int expectedCode, String expectedText) throws Exception {
        assertEquals(expectedCode, response.getStatus());
        responseBody = response.getContentAsString();
        assertTrue(responseBody.contains(expectedText));
    }

}
