package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

    private List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> copyAll() {
        return storage;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void saveResume(Integer key, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void updateResume(Integer key, Resume resume) {
        storage.set(key, resume);
    }

    @Override
    protected Resume getResume(Integer uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void deleteResume(Integer key) {
        storage.remove((int) key);
    }

    @Override
    protected boolean searchKey(Integer key) {
        return key != null && key >= 0;
    }

    @Override
    protected Integer getKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}