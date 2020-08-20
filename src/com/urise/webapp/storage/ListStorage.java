package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Object getKey(String uuid) {
        return storage.indexOf(new Resume(uuid));
    }

    @Override
    protected void saveResume(Object key, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void updateResume(Object key, Resume resume) {
        storage.set((Integer) key, resume);
    }

    @Override
    protected Resume getResume(Object uuid) {
        return storage.get((Integer) uuid);
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove(new Resume((String) key));
    }

    @Override
    protected void checkNotExist(String uuid) {
        if (storage.indexOf(new Resume(uuid)) < 0) {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    protected void checkExist(String uuid) {
        if (storage.indexOf(new Resume(uuid)) >= 0) {
            throw new ExistStorageException(uuid);
        }
    }
}