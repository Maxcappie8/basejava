package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;
    protected int size = 0;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void saveResume(Object key, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        insertResume(resume, (Integer) key);
        size++;
    }

    @Override
    public void updateResume(Object key, Resume resume) {
        storage[(Integer) key] = resume;
    }

    @Override
    public Resume getResume(Object key) {
        return storage[(Integer) key];
    }

    @Override
    public void deleteResume(Object key) {
        doDeleteResume((Integer) getKey((String) key));
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract Object getKey(String uuid);

    protected abstract void insertResume(Resume resume, int index);

    protected abstract void doDeleteResume(int index);
}