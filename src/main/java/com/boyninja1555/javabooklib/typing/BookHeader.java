package com.boyninja1555.javabooklib.typing;

import org.jetbrains.annotations.NotNull;

/**
 * Container of a book title and author. Use <code>BookHeader.of()</code> to construct a header.
 */
public class BookHeader {
    private @NotNull String title = "Untitled";
    private @NotNull String author = "Anonymous";

    /**
     * Gets the title
     *
     * @return Title
     */
    public @NotNull String title() {
        return title;
    }

    /**
     * Sets the title
     *
     * @param title New title
     */
    public void title(@NotNull String title) {
        this.title = title;
    }

    /**
     * Gets the author
     *
     * @return Author
     */
    public @NotNull String author() {
        return author;
    }

    /**
     * Sets the author
     *
     * @param author New author
     */
    public void author(@NotNull String author) {
        this.author = author;
    }

    /**
     * Container of a book title and author.
     *
     * @param title  Book title
     * @param author Book author
     * @return New BookHeader
     */
    public static @NotNull BookHeader of(@NotNull String title, @NotNull String author) {
        BookHeader header = new BookHeader();
        header.title(title);
        header.author(author);
        return header;
    }
}
