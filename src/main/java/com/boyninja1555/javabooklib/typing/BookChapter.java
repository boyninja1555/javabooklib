package com.boyninja1555.javabooklib.typing;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Container of BookPage(s).
 *
 * @param pages Mutable list of BookPage(s)
 */
public record BookChapter(@NotNull List<BookPage> pages) {

    /**
     * Container of BookPage(s).
     *
     * @param pages Mutable list of BookPage(s)
     */
    public static @NotNull BookChapter of(@NotNull List<BookPage> pages) {
        return new BookChapter(pages);
    }
}
