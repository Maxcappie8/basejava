package com.urise.webapp.model;

import java.util.EnumMap;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    private final String uuid;

    private final String fullName;

    private final EnumMap<ContactType, Contact> contacts = new EnumMap<>(ContactType.class);

    private final EnumMap<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public EnumMap<ContactType, Contact> getContacts() {
        return contacts;
    }

    public EnumMap<SectionType, Section> getSections() {
        return sections;
    }

    public Contact getContact(ContactType type) {
        return contacts.get(type);
    }

    public Section getSection(SectionType type) {
        return sections.get(type);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid) && fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid) * Objects.hash(fullName) * 23;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                ", contact=" + contacts +
                ", section=" + sections +
                '}';
    }

    @Override
    public int compareTo(Resume resume) {
        int compare = fullName.compareTo(resume.fullName);
        return compare != 0 ? compare : uuid.compareTo(resume.getUuid());
    }
}