package com.github.xrapalexandra.model;

import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    private List<Book> books = new ArrayList<>();

    public BookStore() {
    }

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book getByIndex(int index) {
        return books.get(index);
    }

    public void add(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookStore bookStore = (BookStore) o;
        return Objects.equal(books, bookStore.books);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(books);
    }
}
