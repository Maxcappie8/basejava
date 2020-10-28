package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeKeyStorage extends AbstractStorage<Resume> {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected Resume getKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void saveResume(Resume key, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume(Resume key, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Resume key) {
        return storage.get(key.getUuid());
    }

    @Override
    protected void deleteResume(Resume key) {
        storage.remove(key.getUuid());
    }

    @Override
    protected boolean searchKey(Resume key) {
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
