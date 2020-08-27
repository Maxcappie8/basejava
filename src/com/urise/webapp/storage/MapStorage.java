package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

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