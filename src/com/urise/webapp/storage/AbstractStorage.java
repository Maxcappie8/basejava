package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage<SK> implements Storage {

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

    private SK checkNotExist(String uuid) {
        SK key = getKey(uuid);
        if (searchKey(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    private SK checkExist(String uuid) {
        SK key = getKey(uuid);
        if (!searchKey(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected abstract SK getKey(String uuid);

    protected abstract void saveResume(SK key, Resume resume);

    protected abstract void updateResume(SK key, Resume resume);

    protected abstract Resume getResume(SK key);

    protected abstract void deleteResume(SK key);

    protected abstract boolean searchKey(SK key);
}