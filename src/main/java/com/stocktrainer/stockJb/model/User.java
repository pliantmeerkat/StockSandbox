package com.stocktrainer.stockJb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * <h1>User</h1>
 * <p>Base user class</p>
 */
public class User implements ApplicationModel {

    @Id
    private ObjectId _id;

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {}

    public Object get_id() {
        return this._id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getUsername() {
        return  this.username;
    }

    public String getPassword() {return this.password;}

    @Override
    public String toString() {
        return "username:".concat(this.username);
    }
}
