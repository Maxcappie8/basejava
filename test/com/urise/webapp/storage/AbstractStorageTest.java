package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {

    Storage storage;
    private final String UUID_1 = "uuid_#1";
    private final String UUID_2 = "uuid_#2";
    private final String UUID_3 = "uuid_#3";
    private final String UUID_4 = "uuid_#4";
    private final String fullName_1 = "Alex Will";
    private final String fullName_2 = "Borat Kaz";
    private final String fullName_3 = "Cindy Kraft";
    private final String fullName_4 = "Donald Duck";
    private final Resume r1 = new Resume(UUID_1, fullName_1);
    private final Resume r2 = new Resume(UUID_2, fullName_2);
    private final Resume r3 = new Resume(UUID_3, fullName_3);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
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
        Resume r4 = new Resume(UUID_4, fullName_4);
        storage.save(r4);
        assertEquals(4, storage.size());
        assertEquals(r4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        Resume r4 = new Resume(UUID_1, fullName_1);
        storage.save(r4);
    }

    @Test
    public void update() {
        Resume r3 = new Resume(UUID_3, fullName_3);
        storage.update(r3);
        assertEquals(3, storage.size());
        assertEquals(r3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume r4 = new Resume(UUID_4);
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
    public void getSortedAll() {
        List<Resume> testList = new ArrayList<>();
        testList.add(0, r1);
        testList.add(1, r2);
        testList.add(2, r3);
        assertEquals(testList, storage.getAllSorted());
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }
}