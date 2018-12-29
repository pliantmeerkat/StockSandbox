package com.stocktrainer.stockJb.service;

import com.stocktrainer.stockJb.enums.ErrorConstants;
import com.stocktrainer.stockJb.exception.InvalidJsonException;
import com.stocktrainer.stockJb.exception.UserAuthenticationException;
import com.stocktrainer.stockJb.exception.UserRegistrationException;
import com.stocktrainer.stockJb.model.User;
import com.stocktrainer.stockJb.repositories.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * <h1>UsersAuthorizationTest</h1>
 * <p>Test class for users authorization service</p>
 *
 * @author jackbranch
 */
public class UsersAuthorizationTest extends ServiceTest {

    @MockBean
    private UsersRepository mockRepository;

    private String testJson;
    private User testUser;
    private User fetchedUser;
    private final String testUsername = "testUser1";
    private final String testPassword = "testPassword1";

    @Before
    public void initialize() {
        testUser = new User(testUsername, testPassword);
        testJson = "{\"username\":\"".concat(testUsername).concat("\",\"password\":\"").concat(testPassword).concat("\"}");
    }

    @Test
    public void testProcessUserRegistrationWithValidUsername() throws Exception {
        when(mockRepository.findByUsername(testUsername)).thenReturn(null);
        when(mockRepository.save(any())).thenReturn(testUser);
        fetchedUser = UsersAuthorization.processUserRegistration(testJson, mockRepository);
        assertEquals(testUsername, fetchedUser.getUsername());
    }

    @Test
    public void testProcessUserRegistrationWithInvalidUsernameAndValidJson() throws Exception {
        try {
            when(mockRepository.findByUsername(testUsername)).thenReturn(testUser);
            fetchedUser = UsersAuthorization.processUserRegistration(testJson, mockRepository);
            fail("Exception should be thrown with in use username");
        } catch (UserRegistrationException e) {
            assertEquals(ErrorConstants.REGISTER_USERNAME_TAKEN.toString(), e.getMessage());
        }
    }

    @Test
    public void processUserLoginReturnsUserWithValidJson() throws Exception, UserAuthenticationException {
        when(mockRepository.findByUsername(testUsername)).thenReturn(testUser);
        fetchedUser = UsersAuthorization.processUserLogin(testJson, mockRepository);
        assertEquals(testUsername, fetchedUser.getUsername());
    }

    @Test
    public void processUserLoginThrowsWithInvalidUsername() throws Exception {
        when(mockRepository.findByUsername(testUsername)).thenReturn(null);
        try {
            fetchedUser = UsersAuthorization.processUserLogin(testJson, mockRepository);
            fail("Exception should be thrown with invalid username");
        } catch (UserAuthenticationException e) {
            assertEquals(ErrorConstants.LOGIN_INVALID.toString(), e.getMessage());
        }
    }

    @Test
    public void processUserLoginThrowsWithInvalidPassword() throws Exception {
        when(mockRepository.findByUsername(testUsername)).thenReturn(new User(testUsername, "invalidPassword"));
        try {
            fetchedUser = UsersAuthorization.processUserLogin(testJson, mockRepository);
            fail("Exception should be thrown with invalid password");
        } catch (UserAuthenticationException e) {
            assertEquals(ErrorConstants.LOGIN_INVALID.toString(), e.getMessage());
        }
    }

    // Invalid Json tests

    @Test
    public void testInvalidJsonFieldsMissingThrowsException() throws Exception{
        testJson = ("{\"password\":\"").concat(testPassword).concat("\"}");
        try {
            fetchedUser = UsersAuthorization.processUserRegistration(testJson, mockRepository);
            fail("Exception should be thrown with invalid json");
        } catch(InvalidJsonException e) {
            assertEquals(ErrorConstants.JSON_FORMATTING_BASIC.toString(), e.getMessage());
        }
    }

    @Test
    public void testInvalidJsonSyntaxIncorrectThrowsException() throws Exception{
        testJson="invalid json";
        try {
            fetchedUser = UsersAuthorization.processUserRegistration(testJson, mockRepository);
            fail("Exception should be thrown with invalid json");
        } catch(InvalidJsonException e) {
            assertEquals(ErrorConstants.JSON_FORMATTING_INVALID.toString(), e.getMessage());
        }
    }
}
