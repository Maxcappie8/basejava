package com.urise.webapp.storage;

import com.urise.webapp.storage.serialization.XmlSerializer;

public class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlSerializer()));
    }
}