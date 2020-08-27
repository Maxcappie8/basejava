package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getKey(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid));
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
        int fromIndex = -index - 1;
        System.arraycopy(storage, fromIndex, storage, fromIndex + 1, size - fromIndex);
        storage[fromIndex] = resume;
    }

    @Override
    protected void doDeleteResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }
}