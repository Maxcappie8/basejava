package com.urise.webapp.exception;

import java.io.IOException;

public class StorageException extends RuntimeException {

    private final String uuid;

    public StorageException(String error_message) {
        this(error_message, null, null);
    }

    public StorageException(String error_message, String uuid) {
        super(error_message);
        this.uuid = uuid;
    }

    public StorageException(String error_message, String uuid, Exception e) {
        super(error_message, e);
        this.uuid = uuid;
    }
}