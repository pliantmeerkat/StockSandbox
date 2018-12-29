package com.stocktrainer.stockJb.model;
/**
 * <h1>User</h1>
 * <p>Base user class</p>
 */
public class User extends DatabaseModel {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {}

    public String getUsername() {
        return  this.username;
    }

    public String getPassword() {return this.password;}

    @Override
    public String toString() {
        return "Username".concat(this.username);
    }
}
