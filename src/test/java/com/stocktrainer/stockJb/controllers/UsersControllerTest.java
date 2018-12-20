package com.stocktrainer.stockJb.controllers;

import com.stocktrainer.stockJb.fixtures.DbTestSetup;
import com.stocktrainer.stockJb.model.User;
import com.stocktrainer.stockJb.repositories.UsersRepository;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class UsersControllerTest {

    @Autowired
    private MockMvc mockController;

    @MockBean
    private UsersRepository mockRepository;

    private String test_id = "testId";
    private User testUser = new User("testUser1", "testUser1");

    @Before
    public void initialize() {
        DbTestSetup.addTestData();
    }

    @After
    public void clearUp() {
        DbTestSetup.clearTestData();
    }

    @Test
    public void getIdReturnsTestUserWithTestId() {
        when(mockRepository.findBy_id(new ObjectId(test_id))).thenReturn(testUser);

    }

    @Test
    public void getUsernameReturnsTestUserWithUsername() {

    }

}
