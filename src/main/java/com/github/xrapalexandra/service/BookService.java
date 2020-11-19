package com.github.xrapalexandra.service;

import com.github.xrapalexandra.model.Book;
import com.github.xrapalexandra.model.BookStore;
import com.github.xrapalexandra.model.PublishHouse;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    public List<Book> findAllByAuthor(BookStore bookStore, String author) {
        List<Book> rightBooks = bookStore.getBooks().stream()
                .filter(x -> x.getAuthors().contains(author))
                .collect(Collectors.toList());

        return rightBooks;
    }

    public List<Book> findAllByPublishingHouse(BookStore bookStore, PublishHouse publishHouse) {
        List<Book> rightBooks = bookStore.getBooks().stream()
                .filter(x -> x.getPublishHouse() == publishHouse)
                .collect(Collectors.toList());
        return rightBooks;
    }

    public List<Book> findAllPublishingAfterYear(BookStore bookStore, int year) {
        List<Book> rightBooks = bookStore.getBooks().stream()
                .filter(x -> x.getPublishingYear() > year)
                .collect(Collectors.toList());
        return rightBooks;
    }
}
