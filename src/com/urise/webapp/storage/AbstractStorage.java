package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        saveResume(checkExist(resume.getUuid()), resume);
    }

    @Override
    public void update(Resume resume) {
        updateResume(checkNotExist(resume.getUuid()), resume);
    }

    @Override
    public Resume get(String uuid) {
        return getResume(checkNotExist(uuid));
    }

    @Override
    public void delete(String uuid) {
        deleteResume(checkNotExist(uuid));
    }

    protected Object checkNotExist(String uuid) {
        if (!searchKey(getKey(uuid))) {
            throw new NotExistStorageException(uuid);
        }
        return getKey(uuid);
    }

    protected Object checkExist(String uuid) {
        if (searchKey(getKey(uuid))) {
            throw new ExistStorageException(uuid);
        }
        return getKey(uuid);
    }

    protected abstract Object getKey(String uuid);

    protected abstract void saveResume(Object key, Resume resume);

    protected abstract void updateResume(Object key, Resume resume);

    protected abstract Resume getResume(Object key);

    protected abstract void deleteResume(Object key);

    protected abstract boolean searchKey(Object key);
}