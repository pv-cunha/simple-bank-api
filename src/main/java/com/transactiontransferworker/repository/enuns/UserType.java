package com.transactiontransferworker.repository.enuns;

import com.transactiontransferworker.exceptions.UserNotFoundException;

import java.util.Arrays;

public enum UserType {

    COMMON("common"),
    MERCHANT("merchant"),
    MANAGER("manager"),
    ADMIN("admin");

    private final String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
}
