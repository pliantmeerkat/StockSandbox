package com.stocktrainer.stockJb.controllers;

import com.stocktrainer.stockJb.authorization.UsersAuthorization;
import com.stocktrainer.stockJb.enums.Endpoints;
import com.stocktrainer.stockJb.enums.ErrorConstants;
import com.stocktrainer.stockJb.fixtures.DbTestSetup;
import com.stocktrainer.stockJb.model.User;
import com.stocktrainer.stockJb.repositories.UsersRepository;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import sun.jvm.hotspot.debugger.Page;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class UsersControllerTest extends ControllerTest {

    @MockBean
    private UsersRepository mockRepository;

    private String test_id = "5349b4ddd2781d08c09890f3";
    private String testUsername = "testUser1";
    private User testUser = new User(testUsername, "testUser1");

    @Before
    public void initialize() {
        endpointUrl = BASE_URL.concat(Endpoints.USERS.toString());
    }

    @After
    public void clearUp() {

    }

    private MockHttpServletResponse makeGetRequest(String url) throws Exception {
        return mockController.perform(get(url).accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
    }

    private MockHttpServletResponse makePostRequest(String url, String requestBody) throws Exception {
        return mockController.perform(post(url)
                .accept(MediaType.APPLICATION_JSON)
                .param("userJson", requestBody))
                .andReturn().getResponse();

    }

    private void verifyResponseContent(int expectedCode, String expectedText) throws Exception {
        assertEquals(expectedCode, response.getStatus());
        responseBody = response.getContentAsString();
        assertTrue(responseBody.contains(expectedText));
    }

    @Test
    public void getIdReturnsTestUserWithTestId() throws Exception {
        visitUrl = endpointUrl.concat("/id/").concat(test_id);
        when(mockRepository.findBy_id(new ObjectId(test_id))).thenReturn(testUser);
        response = makeGetRequest(visitUrl);
        verifyResponseContent(200, testUsername);
    }

    @Test
    public void getIdReturnsErrorWithNonFoundId() throws Exception {
        visitUrl = endpointUrl.concat("/id/").concat(test_id);
        when(mockRepository.findBy_id(new ObjectId(test_id))).thenReturn(null);
        response = makeGetRequest(visitUrl);
        verifyResponseContent(400, ErrorConstants.NO_USER_FOUND_ID.toString());
    }

    @Test
    public void getUsernameReturnsTestUserWithUsername() throws Exception {
        visitUrl = endpointUrl.concat("/username/").concat(testUsername);
        when(mockRepository.findByUsername(testUsername)).thenReturn(testUser);
        response = makeGetRequest(visitUrl);
        verifyResponseContent(200, testUsername);
    }

    @Test
    public void getUsernameReturnsErrorWithInvalidUsername() throws Exception {
        visitUrl = endpointUrl.concat("/username/").concat(testUsername);
        response = makeGetRequest(visitUrl);
        verifyResponseContent(400, ErrorConstants.NO_USER_FOUND_USERNAME.toString());
    }

    private void processRegistrationTest(User mockReturnValue, int expectedCode, String expectedResponse) throws Exception {
        visitUrl = endpointUrl.concat("/register");
        requestBody = "{\"username\":\"testUser1\", \"password\":\"testUser1\"}";
        when(mockRepository.findByUsername(testUsername)).thenReturn(mockReturnValue);
        response = makePostRequest(visitUrl, requestBody);
        verifyResponseContent(expectedCode, expectedResponse);
    }

    @Test
    public void registerUserReturnsUserWithValidUsername() throws Exception {
        processRegistrationTest(null, 200, testUsername);
    }

    @Test
    public void registerUserReturnsErrorWithInvalidUsername() throws Exception {
        processRegistrationTest(testUser, 400, ErrorConstants.REGISTER_USERNAME_TAKEN.toString());
    }

    private void processLoginTest() {

    }

    @Test
    public void loginUserReturnsUserIdWithValidUsernameAndPassword() {

    }

    @Test
    public void loginUserReturnErrorIdWithValidUsernameAndPassword() {

    }

    private void processDeleteTest() {

    }

    @Test
    public void deleteUserReturnsSuccessWIthValidUser() {

    }

    @Test
    public void deleteUserReturnsErrorWithInvalidUser() {

    }
}
