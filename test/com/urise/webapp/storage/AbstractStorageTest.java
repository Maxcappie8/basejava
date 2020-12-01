package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.urise.webapp.ResumeTestData.createNewResume;
import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {

    protected static final File STORAGE_DIR = new File(".\\storage");

    Storage storage;
    private final String UUID_1 = "uuid_#1";
    private final String UUID_2 = "uuid_#2";
    private final String UUID_3 = "uuid_#3";
    private final String UUID_4 = "uuid_#4";
    private final Resume r1 = createNewResume(UUID_1, "Alex Will");
    private final Resume r2 = createNewResume(UUID_2, "Borat Kazakh");
    private final Resume r3 = createNewResume(UUID_3, "Cindy Kraft");

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        assertEquals(0, storage.size());
        storage.save(r1);
        storage.save(r2);
        storage.save(r3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void save() {
        Resume r4 = createNewResume(UUID_4, "Donald Duck");
        storage.save(r4);
        assertEquals(4, storage.size());
        assertEquals(r4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        Resume r4 = createNewResume(UUID_1, "Alex Will");
        storage.save(r4);
    }

    @Test
    public void update() {
        Resume r3 = createNewResume(UUID_3, "Cindy Kraft");
        storage.update(r3);
        assertEquals(3, storage.size());
        assertEquals(r3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume r4 = createNewResume(UUID_4, "Rick Mock");
        storage.update(r4);
    }

    @Test
    public void get() {
        assertEquals(r1, storage.get(UUID_1));
        assertEquals(r2, storage.get(UUID_2));
        assertEquals(r3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        assertEquals(r1, storage.get(UUID_4));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_2);
        assertEquals(2, storage.size());
        storage.get(UUID_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

    @Test
    public void getAllSorted() {
        List<Resume> testList = Arrays.asList(r2, r1, r3);
        Collections.sort(testList);
        assertEquals(testList, storage.getAllSorted());
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }
}