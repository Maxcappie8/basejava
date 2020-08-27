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
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Object getKey(String uuid) {
        return storage.indexOf(new Resume(uuid));
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
        storage.remove(new Resume((String) key));
    }
}