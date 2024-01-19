package com.transactiontransferworker.utils;

public class PathConstants {

    private PathConstants() {
    }
    // User
    public static final String PATH_TRANSACTION_TRANSFER_WORKER_USER = "/v1/user";
    public static final String PATH_POST_CREATE_USER = "/create";

    // Transaction

    public static final String PATH_TRANSACTION_TRANSFER_WORKER_TRANSACTION = "/v1/transaction";
    public static final String PATH_POST_DEPOSIT_TRANSACTION = "/deposit";

    // Authentication

    public static final String PATH_TRANSACTION_TRANSFER_WORKER_AUTHENTICATION = "/v1/auth";
    public static final String PATH_POST_AUTHENTICATION_LOGIN = "/login";
}
