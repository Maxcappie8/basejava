package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        checkExist(resume.getUuid());
        saveResume(getKey(resume.getUuid()), resume);
    }

    @Override
    public void update(Resume resume) {
        checkNotExist(resume.getUuid());
        updateResume(getKey(resume.getUuid()), resume);
    }

    @Override
    public Resume get(String uuid) {
        checkNotExist(uuid);
        return getResume(getKey(uuid));
    }

    @Override
    public void delete(String uuid) {
        checkNotExist(uuid);
        deleteResume(uuid);
    }

    protected void checkNotExist(String uuid) {
        if ((Integer) getKey(uuid) < 0) {
            throw new NotExistStorageException(uuid);
        }
    }

    protected void checkExist(String uuid) {
        if ((Integer) getKey(uuid) >= 0) {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract Object getKey(String uuid);

    protected abstract void saveResume(Object key, Resume resume);

    protected abstract void updateResume(Object key, Resume resume);

    protected abstract Resume getResume(Object key);

    protected abstract void deleteResume(Object key);
}