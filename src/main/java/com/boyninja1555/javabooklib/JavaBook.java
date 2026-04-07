package com.boyninja1555.javabooklib;

import com.boyninja1555.javabooklib.typing.BookChapter;
import com.boyninja1555.javabooklib.typing.BookHeader;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Container of general book data.
 *
 * @param header   Title and author
 * @param chapters Chapters containing pages containing paragraphs
 */
public record JavaBook(@NotNull BookHeader header, @NotNull List<BookChapter> chapters) {

    /**
     * Fills in JavaBook data from a file (Path).
     *
     * @param filePath Path instance pointing to an existing book file
     */
    public void read(Path filePath) throws IOException {
        if (!Files.exists(filePath)) throw new FileNotFoundException(filePath.toString());
        try (DataInputStream in = new DataInputStream(new FileInputStream(filePath.toString()))) {
            BookHeader inHeader = JavaBookCommons.readHeader(in);
            header.title(inHeader.title());
            header.author(inHeader.author());

            List<BookChapter> inChapters = new ArrayList<>();
            int chapterCount = in.readInt();
            for (int i = 0; i < chapterCount; i++) inChapters.add(JavaBookCommons.readChapter(in));
            chapters.clear();
            chapters.addAll(inChapters);
        }
    }

    /**
     * Writes the JavaBook data to a file (Path).
     *
     * @param filePath Path instance pointing to any file (existing or not)
     */
    public void write(Path filePath) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath.toString()))) {
            JavaBookCommons.writeHeader(out, header);
            out.writeInt(chapters.size());
            for (BookChapter chapter : chapters) JavaBookCommons.writeChapter(out, chapter);
            out.flush();
        }
    }

    /**
     * Creates a new JavaBook from direct data.
     *
     * @param title    Book title
     * @param author   Book author
     * @param chapters Chapters of the book
     * @return New JavaBook
     */
    public static @NotNull JavaBook of(@NotNull String title, @NotNull String author, @NotNull List<BookChapter> chapters) {
        return new JavaBook(BookHeader.of(title, author), chapters);
    }

    /**
     * Creates a new JavaBook from a filePath (Path).
     *
     * @param filePath Path instance pointing to an existing book file
     * @return New JavaBook
     */
    public static JavaBook ofFile(Path filePath) throws IOException {
        JavaBook book = JavaBook.of("Untitled", "Anonymous", List.of());
        book.read(filePath);
        return book;
    }
}
