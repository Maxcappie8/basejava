package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return storage;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void saveResume(Object key, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void updateResume(Object key, Resume resume) {
        storage.set((Integer) key, resume);
    }

    @Override
    protected Resume getResume(Object uuid) {
        return storage.get((Integer) uuid);
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove((int) key);
    }

    @Override
    protected boolean searchKey(Object key) {
        return key != null && (Integer) key >= 0;
    }

    @Override
    protected Object getKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}