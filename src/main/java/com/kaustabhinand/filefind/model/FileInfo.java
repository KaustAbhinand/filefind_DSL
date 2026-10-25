package com.kaustabhinand.filefind.model;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;

/** One file's metadata, read lazily and at most once, so short-circuiting `and` also saves I/O. */
public final class FileInfo {
    private final Path path;
    private BasicFileAttributes attrs;

    public FileInfo(Path path) { this.path = path; }

    public String name() {
        Path n = path.getFileName();
        return n == null ? "" : n.toString();
    }

    public String extension() {
        String name = name();
        int dot = name.lastIndexOf('.');
        return (dot > 0 && dot < name.length() - 1) ? name.substring(dot + 1) : "";
    }

    public long size()        { return attrs().size(); }
    public Instant created()  { return attrs().creationTime().toInstant(); }
    public Instant modified() { return attrs().lastModifiedTime().toInstant(); }

    private BasicFileAttributes attrs() {
        if (attrs == null) {
            try {
                attrs = Files.readAttributes(path, BasicFileAttributes.class);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
        return attrs;
    }
}