package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage<String> {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected String getKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean searchKey(String key) {
        return storage.containsKey(key);
    }

    @Override
    protected void saveResume(String key, Resume resume) {
        storage.put(key, resume);
    }

    @Override
    protected void updateResume(String key, Resume resume) {
        storage.put(key, resume);
    }

    @Override
    protected Resume getResume(String key) {
        return storage.get(key);
    }

    @Override
    protected void deleteResume(String key) {
        storage.remove(key);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> rsm = new ArrayList<>(storage.values());
        rsm.sort(Comparator.comparing(Resume::getFullName));
        return rsm;
    }

    @Override
    public int size() {
        return storage.size();
    }
}