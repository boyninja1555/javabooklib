package com.boyninja1555.javabooklib.typing;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Container of paragraphs for a BookChapter.
 *
 * @param paragraphs List of strings representing paragraphs
 */
public record BookPage(@NotNull List<String> paragraphs) {

    /**
     * Container of paragraphs for a BookChapter.
     *
     * @param paragraphs List of strings representing paragraphs
     */
    public static @NotNull BookPage of(@NotNull List<String> paragraphs) {
        return new BookPage(paragraphs);
    }
}
