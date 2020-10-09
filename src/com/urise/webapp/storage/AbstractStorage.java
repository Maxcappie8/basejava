package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        saveResume(checkNotExist(resume.getUuid()), resume);
    }

    @Override
    public void update(Resume resume) {
        updateResume(checkExist(resume.getUuid()), resume);
    }

    @Override
    public Resume get(String uuid) {
        return getResume(checkExist(uuid));
    }

    @Override
    public void delete(String uuid) {
        deleteResume(checkExist(uuid));
    }

    private Object checkNotExist(String uuid) {
        Object key = getKey(uuid);
        if (searchKey(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    private Object checkExist(String uuid) {
        Object key = getKey(uuid);
        if (!searchKey(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected abstract Object getKey(String uuid);

    protected abstract void saveResume(Object key, Resume resume);

    protected abstract void updateResume(Object key, Resume resume);

    protected abstract Resume getResume(Object key);

    protected abstract void deleteResume(Object key);

    protected abstract boolean searchKey(Object key);
}