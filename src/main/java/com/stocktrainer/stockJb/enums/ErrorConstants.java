package com.stocktrainer.stockJb.enums;

import sun.jvm.hotspot.debugger.Page;

public enum ErrorConstants {

    NO_USER_FOUND_ID("Error: No user found with that id"),
    NO_USER_FOUND_USERNAME("Error: No user found with that id"),
    REGISTER_USERNAME_TAKEN("Error: Username is taken"),
    LOGIN_INVALID("Error: Username of password incorrect");

    private String fieldName;

    ErrorConstants(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return this.fieldName;
    }

}
