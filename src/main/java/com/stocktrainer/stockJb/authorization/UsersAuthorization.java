package com.stocktrainer.stockJb.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stocktrainer.stockJb.enums.ErrorConstants;
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
public class UsersAuthorization implements Authorization {

    public static User processUserRegistration(String userJson, UsersRepository repository) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User createdUser = objectMapper.readValue(userJson, User.class);
        if(null != repository.findByUsername(createdUser.getUsername())) {
            throw new UserRegistrationException(ErrorConstants.REGISTER_USERNAME_TAKEN.toString());
        }
        return repository.save(createdUser);
    }

    public static User processUserUpdate(String userJson, UsersRepository repository) {
        return null;
    }

}
