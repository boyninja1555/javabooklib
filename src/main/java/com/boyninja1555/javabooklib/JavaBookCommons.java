package com.boyninja1555.javabooklib;

import com.boyninja1555.javabooklib.typing.BookChapter;
import com.boyninja1555.javabooklib.typing.BookHeader;
import com.boyninja1555.javabooklib.typing.BookPage;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApiStatus.Internal
public class JavaBookCommons {

    public static @NotNull BookHeader readHeader(@NotNull DataInputStream in) throws IOException {
        return BookHeader.of(in.readUTF(), in.readUTF());
    }

    public static void writeHeader(@NotNull DataOutputStream out, @NotNull BookHeader header) throws IOException {
        out.writeUTF(header.title());
        out.writeUTF(header.author());
    }

    public static @NotNull BookChapter readChapter(@NotNull DataInputStream in) throws IOException {
        List<BookPage> pages = new ArrayList<>();
        int pageCount = in.readInt();
        for (int i = 0; i < pageCount; i++) pages.add(readPage(in));
        return BookChapter.of(pages);
    }

    public static void writeChapter(@NotNull DataOutputStream out, @NotNull BookChapter chapter) throws IOException {
        out.writeInt(chapter.pages().size());
        for (BookPage page : chapter.pages()) writePage(out, page);
    }

    public static @NotNull BookPage readPage(@NotNull DataInputStream in) throws IOException {
        List<String> paragraphs = new ArrayList<>();
        int pageCount = in.readInt();
        for (int i = 0; i < pageCount; i++) paragraphs.add(readParagraph(in));
        return BookPage.of(paragraphs);
    }

    public static void writePage(@NotNull DataOutputStream out, @NotNull BookPage page) throws IOException {
        out.writeInt(page.paragraphs().size());
        for (String paragraph : page.paragraphs()) writeParagraph(out, paragraph);
    }

    public static @NotNull String readParagraph(@NotNull DataInputStream in) throws IOException {
        return in.readUTF();
    }

    public static void writeParagraph(@NotNull DataOutputStream out, @NotNull String paragraph) throws IOException {
        out.writeUTF(paragraph);
    }
}
