package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListStorageTest {

    ListStorage storage = new ListStorage();

    Resume resume = new Resume("1");

    @Before
    public void setUp() {
        storage.save(resume);
    }

    @Test
    public void clear() {
        System.out.println(storage.size());
        storage.clear();
        System.out.println(storage.size());
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void save() {
        storage.save(new Resume("2"));
        Assert.assertEquals(2, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(resume);
    }

    @Test
    public void update() {
        storage.update(new Resume("1"));
        Assert.assertEquals(resume, storage.get("1"));
    }

    @Test (expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("2"));
    }

    @Test
    public void get() {
        Assert.assertEquals(resume, storage.get("1"));
    }

    @Test
    public void delete() {
        storage.delete("1");
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] arrayTest = new Resume[1];
        arrayTest[0] = resume;
        Assert.assertArrayEquals(arrayTest, storage.getAll());
    }

    @Test
    public void size() {
        Assert.assertEquals(1,storage.size());
    }
}