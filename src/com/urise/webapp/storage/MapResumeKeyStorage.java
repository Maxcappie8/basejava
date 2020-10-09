package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeKeyStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected Resume getKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void saveResume(Object key, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume(Object key, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Object key) {
        return storage.get(((Resume) key).getUuid());
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove(((Resume) key).getUuid());
    }

    @Override
    protected boolean searchKey(Object key) {
        return key != null;
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
