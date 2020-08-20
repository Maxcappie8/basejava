package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public Integer getKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
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
    protected void insertResume(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void deleteResume(int index) {
        storage[index] = storage[size - 1];
    }
}