package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class MapStorage extends AbstractStorage {

    @Override
    protected Object getKey(String uuid) {
        return null;
    }

    @Override
    protected void saveResume(Object key, Resume resume) {

    }

    @Override
    protected void updateResume(Object key, Resume resume) {

    }

    @Override
    protected Resume getResume(Object key) {
        return null;
    }

    @Override
    protected void deleteResume(Object key) {

    }

    @Override
    protected void checkNotExist(String uuid) {

    }

    @Override
    protected void checkExist(String uuid) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
