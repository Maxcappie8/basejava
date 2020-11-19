package com.urise.webapp.storage;

import com.urise.webapp.storage.serialization.ObjectStreamSerializer;

import static org.junit.Assert.*;

public class FileStorageTest extends AbstractStorageTest {
    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }
}