package com.stocktrainer.stockJb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stocktrainer.stockJb.enums.ErrorConstants;
import com.stocktrainer.stockJb.exception.UserAuthenticationException;
import com.stocktrainer.stockJb.exception.UserRegistrationException;
import com.stocktrainer.stockJb.model.User;
import com.stocktrainer.stockJb.repositories.UsersRepository;
import org.springframework.stereotype.Service;

/**
 * <h1>UsersAuthorization</h1>
 * <p>Class used to verify user information </p>
 *
 * @author jackbranch
 */
@Service
public class UsersAuthorization extends Authorization {

    private UsersAuthorization() {}

    /**
     * <h2>processUserRegistration</h2>
     * <p>Function used to process user registration, validates input json before processing registration</p>
     * @param userJson input Json from client
     * @param repository users repository to process user db requests
     * @return new user
     * @throws Exception when json is invalid or username is in use
     */
    public static User processUserRegistration(String userJson, UsersRepository repository) throws Exception {
        User createdUser = getUserFromJson(userJson);
        if(null != repository.findByUsername(createdUser.getUsername())) {
            throw new UserRegistrationException(ErrorConstants.REGISTER_USERNAME_TAKEN.toString());
        }
        return repository.save(createdUser);
    }

    /**
     * <h2>processUserLogin</h2>
     * <p>Function used to process user login, validates input json before processing login</p>
     * @param userJson input Json from client
     * @param repository users repository to process user db requests
     * @return user fetched from db collection
     * @throws Exception when json, username or password are invalid
     */
    public static User processUserLogin(String userJson, UsersRepository repository) throws Exception, UserAuthenticationException{
        User loggedInUser = getUserFromJson(userJson);
        if(null == repository.findByUsername(loggedInUser.getUsername())) {
            throw new UserAuthenticationException(ErrorConstants.LOGIN_INVALID.toString());
        }
        User foundUser = repository.findByUsername(loggedInUser.getUsername());
        if(!loggedInUser.getUsername().equals(foundUser.getUsername()) || !loggedInUser.getPassword().equals(foundUser.getPassword())) {
            throw new UserAuthenticationException(ErrorConstants.LOGIN_INVALID.toString());
        }
        return foundUser;
    }

    public static User processUserUpdate(String userJson, UsersRepository repository) {
        return null;
    }

    /**
     * <h2>getUserFromJson</h2>
     * <p>Function used tio extract user object from in put json, validates json syntax is valid then maps to object</p>
     * @param userJson input Json from client
     * @return mapped user object
     * @throws Exception when json is invalid
     */
    private static User getUserFromJson(String userJson) throws Exception {
        verifyJsonFormatting(userJson);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(userJson, User.class);
    }
}
