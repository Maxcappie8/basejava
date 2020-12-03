package com.urise.webapp.storage.serialization;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {
    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(os)) {
            dataOutputStream.writeUTF(resume.getUuid());
            dataOutputStream.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            writeElement(dataOutputStream, contacts.entrySet(), entry -> {
                dataOutputStream.writeUTF(entry.getKey().name());
                dataOutputStream.writeUTF(entry.getValue());
            });

            writeElement(dataOutputStream, resume.getSections().entrySet(), entry -> {
                SectionType sectionType = entry.getKey();
                AbstractSection section = entry.getValue();
                dataOutputStream.writeUTF(sectionType.name());
                switch (sectionType) {
                    case PERSONAL:
                    case OBJECTIVE:
                        dataOutputStream.writeUTF(((TextSection) section).getTextLine());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeElement(dataOutputStream, ((ListSection) section).getListContent(), dataOutputStream::writeUTF);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        writeElement(dataOutputStream, ((CompanySection) section).getCompanyList(), company -> {
                            WebLink homePage = company.getHomePage();
                            dataOutputStream.writeUTF(homePage.getName());
                            dataOutputStream.writeUTF(homePage.getUrl());
                            writeElement(dataOutputStream, company.getPositionsList(), position -> {
                                writeDate(dataOutputStream, position.getStartDate());
                                writeDate(dataOutputStream, position.getEndDate());
                                dataOutputStream.writeUTF(position.getTitle());
                                dataOutputStream.writeUTF(position.getDescription());
                            });
                        });
                        break;
                }
            });
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(is)) {
            String uuid = dataInputStream.readUTF();
            String fullName = dataInputStream.readUTF();
            Resume resume = new Resume(uuid, fullName);
            readElement(dataInputStream, () -> resume.addContact(ContactType.valueOf(dataInputStream.readUTF()), dataInputStream.readUTF()));

            readElement(dataInputStream, () -> {
                SectionType sectionType = SectionType.valueOf(dataInputStream.readUTF());
                resume.addSection(sectionType, readSection(dataInputStream, sectionType));
            });
            return resume;
        }
    }

    private AbstractSection readSection(DataInputStream dataInputStream, SectionType sectionType) throws IOException {
        switch (sectionType) {
            case PERSONAL:
            case OBJECTIVE:
                return new TextSection(dataInputStream.readUTF());
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                return new ListSection(createList(dataInputStream, dataInputStream::readUTF));
            case EXPERIENCE:
            case EDUCATION:
                return new CompanySection(
                        createList(dataInputStream, () -> new Company(
                                new WebLink(dataInputStream.readUTF(), dataInputStream.readUTF()), createList(dataInputStream, () -> new Company.Position(
                                    readDate(dataInputStream), readDate(dataInputStream), dataInputStream.readUTF(), dataInputStream.readUTF()
                        ))))
                );

        }
        return null;
    }

    private <T> List<T> createList(DataInputStream dataInputStream, ElementReader<T> reader) throws IOException {
        int size = dataInputStream.readInt();
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(reader.read());
        }
        return list;
    }

    private void writeDate(DataOutputStream dos, LocalDate ld) throws IOException {
        dos.writeInt(ld.getYear());
        dos.writeInt(ld.getMonth().getValue());
    }

    private LocalDate readDate(DataInputStream dis) throws IOException {
        return LocalDate.of(dis.readInt(), dis.readInt(), 1);
    }

    private interface ElementWriter<T> {
        void write(T t) throws IOException;
    }

    private interface ElementCreator {
        void create() throws IOException;
    }

    private interface ElementReader<T> {
        T read() throws IOException;
    }

    private void readElement(DataInputStream dis, ElementCreator elementReader) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            elementReader.create();
        }
    }

    private <T> void writeElement(DataOutputStream dos, Collection<T> collection, ElementWriter<T> elementWriter) throws IOException {
        dos.writeInt(collection.size());
        for (T element : collection) {
            elementWriter.write(element);
        }
    }
}