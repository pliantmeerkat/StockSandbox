package com.stocktrainer.stockJb.enums;

public enum ErrorConstants {

    NO_USER_FOUND_ID("Error: No user found with that id"),
    NO_USER_FOUND_USERNAME("Error: No user found with that id"),
    REGISTER_USERNAME_TAKEN("Error: Username is taken"),
    LOGIN_INVALID("Error: Username of password incorrect"),
    JSON_FORMATTING_BASIC("Error: Json formatting is incorrect"),
    JSON_FORMATTING_SPECIFIC("Error: Json formatting is incorrect at:\n"),
    JSON_FORMATTING_INVALID("Error: Json syntax is invalid");

    private String fieldName;

    ErrorConstants(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return this.fieldName;
    }

}
