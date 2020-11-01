package com.urise.webapp.exception;

import java.io.IOException;

public class StorageException extends RuntimeException {

    private final String uuid;

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public StorageException(String error_message, String uuid, Exception e) {
        super(error_message, e);
        this.uuid = uuid;
    }
}