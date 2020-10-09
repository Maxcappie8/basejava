package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getKey(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid, ""), Comparator.comparing(Resume::getUuid));
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