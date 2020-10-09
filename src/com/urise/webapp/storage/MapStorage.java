package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected Object getKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean searchKey(Object key) {
        return storage.containsKey(key);
    }

    @Override
    protected void saveResume(Object key, Resume resume) {
        storage.put((String) key, resume);
    }

    @Override
    protected void updateResume(Object key, Resume resume) {
        storage.put((String) key, resume);
    }

    @Override
    protected Resume getResume(Object key) {
        return storage.get(key);
    }

    @Override
    protected void deleteResume(Object key) {
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