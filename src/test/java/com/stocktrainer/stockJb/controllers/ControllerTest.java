package com.stocktrainer.stockJb.controllers;

import com.stocktrainer.stockJb.enums.UrlConstants;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
public abstract class ControllerTest {

    final String BASE_URL = UrlConstants.BASE_URL_LOCAL.toString();
    String endpointUrl;
    String visitUrl;
    String responseBody;
    String requestBody;

    @Autowired
    MockMvc mockController;

    MockHttpServletResponse response;

    abstract void initialize();
    abstract void clearUp();

}
