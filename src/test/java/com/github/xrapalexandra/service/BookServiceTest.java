package com.github.xrapalexandra.service;

import com.github.xrapalexandra.exception.BookExceptoin;
import com.github.xrapalexandra.model.Book;
import com.github.xrapalexandra.model.BookStore;
import com.github.xrapalexandra.model.Cover;
import com.github.xrapalexandra.model.PublishHouse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookServiceTest extends Assert {

    BookService bookService = new BookService();
    BookStore bookStore = new BookStore();

    @BeforeClass
    public void setUp() throws BookExceptoin {
        bookStore.add(new Book("Алые паруса", Collections.singletonList("А.Грин"), PublishHouse.CLEVER, 1982, 54, Cover.HARD));
        bookStore.add(new Book("Идиот", Collections.singletonList("Ф.Достоевский"), PublishHouse.DELIBRI, 1993, 42, Cover.HARD));
        bookStore.add(new Book("Рамзес", Collections.singletonList("А.Блок"), PublishHouse.EXMO, 2001, 84, Cover.SOFT));
        bookStore.add(new Book("Сказки", Collections.singletonList("А.Пушкин"), PublishHouse.CLEVER, 2011, 30, Cover.SOFT));
    }

    @Test
    public void testFindAllByAuthor() {
        Book book = bookStore.getByIndex(0);
        List<Book> actual = bookService.findAllByAuthor(bookStore, "А.Грин");
        List<Book> expected = new ArrayList<>();
        expected.add(book);

        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllByPublishingHouse() {
        Book book1 = bookStore.getByIndex(0);
        Book book2 = bookStore.getByIndex(3);
        List<Book> actual = bookService.findAllByPublishingHouse(bookStore, PublishHouse.CLEVER);
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);

        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllPublishingAfterYear() {
        Book book1 = bookStore.getByIndex(2);
        Book book2 = bookStore.getByIndex(3);
        List<Book> actual = bookService.findAllPublishingAfterYear(bookStore, 2000);
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);

        assertEquals(actual, expected);
    }

}