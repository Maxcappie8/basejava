package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

    protected static final int STORAGE_LIMIT = 10000;
    protected int size = 0;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void saveResume(Integer key, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        insertResume(resume, key);
        size++;
    }

    @Override
    public void updateResume(Integer key, Resume resume) {
        storage[key] = resume;
    }

    @Override
    public Resume getResume(Integer key) {
        return storage[key];
    }

    @Override
    public void deleteResume(Integer key) {
        doDeleteResume(key);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<Resume> copyAll() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    protected boolean searchKey(Integer key) {
        return (key >= 0);
    }

    protected abstract Integer getKey(String uuid);

    protected abstract void insertResume(Resume resume, int index);

    protected abstract void doDeleteResume(int index);
}