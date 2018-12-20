package com.stocktrainer.stockJb.controllers;

import com.stocktrainer.stockJb.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController implements ApplicationController {

    @Autowired
    UsersRepository repository;

}
