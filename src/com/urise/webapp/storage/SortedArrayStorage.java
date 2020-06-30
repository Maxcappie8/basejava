package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int findResumesIndexInStorage(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid));
    }

    @Override
    protected void insertResumeInStorage(Resume resume, int index) {
        int fromIndex = -(++index);
        System.arraycopy(storage, fromIndex, storage, fromIndex + 1, size - fromIndex);
        storage[fromIndex] = resume;
    }

    @Override
    protected void deleteByIndex(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }
}