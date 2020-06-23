package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private int size = 0;
    private Resume[] storage = new Resume[4];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size < storage.length && !findResumeInStorage(resume)) {
            storage[size++] = resume;
        } else if (findResumeInStorage(resume)) {
            System.out.println("[INFO] Resume already exists.");
        } else {
            System.out.println("[INFO] Storage is full.");
        }
    }

    public void update(Resume resume) {
        if (findResumeInStorage(resume)) {
            storage[findResumesIndexInStorage(resume)] = resume;
        } else {
            System.out.println("[INFO] Resume not found.");
        }
    }

    public Resume get(String uuid) {
        if (findResumeInStorage(uuid)) {
            return storage[findResumesIndexInStorage(uuid)];
        } else {
            System.out.println("[INFO] Resume not found.");
            return null;
        }
    }

    public void delete(String uuid) {
        if (findResumeInStorage(uuid)) {
            storage[findResumesIndexInStorage(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("[INFO] Resume not found.");
        }
    }

    private boolean findResumeInStorage(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                return true;
            }
        }
        return false;
    }

    private boolean findResumeInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    private int findResumesIndexInStorage(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                return i;
            }
        }
        return 0;
    }

    private int findResumesIndexInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}