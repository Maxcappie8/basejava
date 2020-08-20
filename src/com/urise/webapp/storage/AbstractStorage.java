package com.urise.webapp.storage;

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

    protected abstract Object getKey(String uuid);

    protected abstract void saveResume(Object key, Resume resume);

    protected abstract void updateResume(Object key, Resume resume);

    protected abstract Resume getResume(Object key);

    protected abstract void deleteResume(Object key);

    protected abstract void checkNotExist(String uuid);

    protected abstract void checkExist(String uuid);
}