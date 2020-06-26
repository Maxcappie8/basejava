package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private int size = 0;
    private Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size < storage.length && findResumesIndexInStorage(resume.getUuid()) == size) {
            storage[size++] = resume;
        } else if (findResumesIndexInStorage(resume.getUuid()) < size) {
            System.out.println("[INFO] Resume " + resume.getUuid() + " already exists.");
        } else {
            System.out.println("[INFO] Storage is full.");
        }
    }

    public void update(Resume resume) {
        int targetResumesIndex = findResumesIndexInStorage(resume.getUuid());
        if (targetResumesIndex < size) {
            storage[targetResumesIndex] = resume;
        } else {
            System.out.println("[INFO] Resume " + resume.getUuid() + " not found.");
        }
    }

    public Resume get(String uuid) {
        int targetResumesIndex = findResumesIndexInStorage(uuid);
        if (targetResumesIndex < size) {
            return storage[targetResumesIndex];
        }
        System.out.println("[INFO] Resume " + uuid + " not found.");
        return null;
    }

    public void delete(String uuid) {
        int targetResumesIndex = findResumesIndexInStorage(uuid);
        if (targetResumesIndex < size) {
            storage[targetResumesIndex] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("[INFO] Resume " + uuid + " not found.");
        }
    }

    private int findResumesIndexInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return size;
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