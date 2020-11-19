package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serialization.StreamSerializer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {

    private final Path directory;
    private StreamSerializer serializer;

    protected PathStorage(String dir, StreamSerializer serializer) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        Objects.requireNonNull(serializer, "serializer must not be null");
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException(dir + " is not directory");
        }
        if (!Files.isReadable(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not readable/writable");
        }
        this.serializer = serializer;
    }

    @Override
    protected Path getKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected void saveResume(Path path, Resume resume) {
        try {
            Files.createFile(path);
            serializer.doWrite(resume, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StorageException("IO ERROR", path.toString(), e);
        }
    }

    @Override
    protected void updateResume(Path path, Resume resume) {
        try {
            serializer.doWrite(resume, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StorageException("IO ERROR", path.toString(), e);
        }
    }

    @Override
    protected Resume getResume(Path path) {
        try {
            return serializer.doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("File read error", path.toString(), e);
        }
    }

    @Override
    protected void deleteResume(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Can't delete file", path.toString(), e);
        }
    }

    @Override
    protected boolean searchKey(Path path) {
        return Files.exists(path);
    }

    @Override
    public void clear() {
        toStream().forEach(this::deleteResume);
    }

    @Override
    public int size() {
        return (int) toStream().count();
    }

    @Override
    protected List<Resume> copyAll() {
        List<Resume> listAllResume = toStream().map(this::getResume).collect(Collectors.toList());
        return listAllResume;
    }

    private Stream<Path> toStream() {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("Directory error", directory.toString(), e);
        }
    }
}