package com.urise.webapp.storage.serialization;

import com.urise.webapp.model.*;
import com.urise.webapp.util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XmlSerializer implements StreamSerializer {

    private XmlParser xmlParser;

    public XmlSerializer() {
        xmlParser = new XmlParser(Resume.class,
                Company.class,
                Company.Position.class,
                WebLink.class,
                AbstractSection.class
        );
    }

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8))) {
            xmlParser.marshall(resume, writer);
        }
    }


    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            return xmlParser.unmarshall(reader);
        }
    }
}