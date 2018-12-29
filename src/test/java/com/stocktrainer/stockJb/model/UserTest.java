package com.stocktrainer.stockJb.model;

public class UserTest implements ModelTest {

    private User testUser;

    private String testUsername = "testUser1";
    private String testPassword = "testPassword1";

    public void initialize() {
        testUser = new User(testUsername, testPassword);
    }
}
