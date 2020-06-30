package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 3;
    protected int size = 0;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume resume) {
        int targetResumesIndex = findResumesIndexInStorage(resume.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("[INFO] Storage is full.");
        } else if (targetResumesIndex >= 0) {
            System.out.println("[INFO] Resume " + resume.getUuid() + " already exists.");
        } else {
            insertResumeInStorage(resume, targetResumesIndex);
            size++;
        }
    }

    @Override
    public void update(Resume resume) {
        int targetResumesIndex = findResumesIndexInStorage(resume.getUuid());
        if (targetResumesIndex < 0) {
            System.out.println("[INFO] Resume " + resume.getUuid() + " not found.");
        } else {
            storage[targetResumesIndex] = resume;
        }
    }

    @Override
    public Resume get(String uuid) {
        int targetResumesIndex = findResumesIndexInStorage(uuid);
        if (targetResumesIndex < 0) {
            System.out.println("[INFO] Resume " + uuid + " not found.");
            return null;
        }
        return storage[targetResumesIndex];
    }

    @Override
    public void delete(String uuid) {
        int targetResumesIndex = findResumesIndexInStorage(uuid);
        if (targetResumesIndex < 0) {
            System.out.println("[INFO] Resume " + uuid + " not found.");
        } else {
            deleteByIndex(targetResumesIndex);
            size--;
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract int findResumesIndexInStorage(String uuid);

    protected abstract void insertResumeInStorage(Resume resume, int index);

    protected abstract void deleteByIndex(int index);
}