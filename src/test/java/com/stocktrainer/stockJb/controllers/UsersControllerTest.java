package com.stocktrainer.stockJb.controllers;

import com.stocktrainer.stockJb.enums.Endpoints;
import com.stocktrainer.stockJb.enums.ErrorConstants;
import com.stocktrainer.stockJb.model.User;
import com.stocktrainer.stockJb.repositories.UsersRepository;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class UsersControllerTest extends ControllerTest {

    @MockBean
    private UsersRepository mockRepository;

    private User testUser;

    private String testUsername = "testUser1";
    private String testPassword = "testPassword1";

    @Before
    public void initialize() {
        testUser = new User(testUsername, testPassword);
        endpointUrl = BASE_URL.concat(Endpoints.USERS.toString());
    }

    @After
    public void clearUp() {

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
        when(mockRepository.save(any())).thenReturn(testUser);
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

    private void processLoginTest(String inputPassword, User mockReturnValue, int expectedCode, String expectedResponse) throws Exception{
        visitUrl = endpointUrl.concat("/login");
        requestBody = "{\"username\":\"testUser1\", \"password\":\"".concat(inputPassword).concat("\"}");
        when(mockRepository.findByUsername(testUsername)).thenReturn(mockReturnValue);
        when(mockRepository.save(any())).thenReturn(testUser);
        response = makePostRequest(visitUrl, requestBody);
        verifyResponseContent(expectedCode, expectedResponse);
    }

    @Test
    public void loginUserReturnsUserWithValidUsernameAndPassword() throws Exception{
        processLoginTest(testPassword, testUser, 200, testUsername);
    }

    @Test
    public void loginUserReturnErrorIdWithValidUsernameAndWrongPassword() throws Exception {
        String invalidPassword = "invalidPassword";
        processLoginTest(invalidPassword, testUser, 400, ErrorConstants.LOGIN_INVALID.toString());
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
