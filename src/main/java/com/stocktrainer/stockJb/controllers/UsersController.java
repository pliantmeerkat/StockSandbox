package com.stocktrainer.stockJb.controllers;

import com.stocktrainer.stockJb.service.UsersAuthorization;
import com.stocktrainer.stockJb.enums.ErrorConstants;
import com.stocktrainer.stockJb.model.User;
import com.stocktrainer.stockJb.repositories.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <h1>UsersController</h1>
 * <p></p>
 *
 * @author jackbranch
 */
@RestController
@RequestMapping("/user")
public class UsersController implements ApplicationController {

    User foundUser;

    @Autowired
    UsersRepository repository;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity getUserById(@PathVariable String id) {
        foundUser = repository.findBy_id(new ObjectId(id));
        if(null == foundUser) {
            return new ResponseEntity<>(ErrorConstants.NO_USER_FOUND_ID.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping(value = "/username/{username}")
    public ResponseEntity getUserByUsername(@PathVariable String username) {
        foundUser = repository.findByUsername(username);
        if(null == foundUser) {
            return new ResponseEntity<>(ErrorConstants.NO_USER_FOUND_USERNAME.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity registerUser(String userJson) {
        try {
            foundUser = UsersAuthorization.processUserRegistration(userJson, repository);
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(ErrorConstants.REGISTER_USERNAME_TAKEN.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity loginUser(String userJson) {
        return null;
    }

    @PatchMapping(value = "/update")
    public ResponseEntity updateUser(String userJson) {
        return null;
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteUser(String userJson) {
        return null;
    }
}
