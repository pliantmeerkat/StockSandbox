package com.stocktrainer.stockJb.controllers;

import com.stocktrainer.stockJb.enums.ErrorConstants;
import com.stocktrainer.stockJb.model.User;
import com.stocktrainer.stockJb.repositories.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController implements ApplicationController {

    @Autowired
    UsersRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity getUserById(String id) {
        User foundUser = repository.findBy_id(new ObjectId(id));
        if(null == foundUser) {
            return new ResponseEntity<>(ErrorConstants.NO_USER_FOUND_ID.toString(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity getUserByUsername(String username) {
        User foundUser = repository.findByUsername(username);
        if(null == foundUser) {
            return new ResponseEntity<>(ErrorConstants.NO_USER_FOUND_USERNAME.toString(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }



}
