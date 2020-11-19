package com.github.xrapalexandra.model;

import com.github.xrapalexandra.util.Indexing;
import com.github.xrapalexandra.exception.BookExceptoin;
import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private static final Indexing indexing = new Indexing();

    private int id;
    private String name;
    private List<String> authors;
    private PublishHouse publishHouse;
    private int publishingYear;
    private int price;
    private Cover cover;

    {
        id = indexing.getId();
    }

    public Book() {
    }

    public Book(String name, List<String> authors, PublishHouse publishHouse, int publishingYear, int price, Cover cover) throws BookExceptoin {
        isValidPrice(price);
        this.name = name;
        this.authors = authors;
        this.publishHouse = publishHouse;
        this.publishingYear = publishingYear;
        this.price = price;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthors() {
        return new ArrayList<>(authors);
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String author){
        if(authors == null){
            authors = new ArrayList<>();
        }
        authors.add(author);
    }

    public PublishHouse getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(PublishHouse publishHouse) {
        this.publishHouse = publishHouse;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws BookExceptoin {
        isValidPrice(price);
        this.price = price;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    private void isValidPrice(int price) throws BookExceptoin {
        if(price <= 0 ){
            throw new BookExceptoin(price + " is invalid price!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", authors=").append(authors);
        sb.append(", publishingHouse=").append(publishHouse);
        sb.append(", publishingYear=").append(publishingYear);
        sb.append(", price=").append(price);
        sb.append(", cover=").append(cover);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                publishingYear == book.publishingYear &&
                price == book.price &&
                Objects.equal(name, book.name) &&
                Objects.equal(authors, book.authors) &&
                publishHouse == book.publishHouse &&
                cover == book.cover;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, authors, publishHouse, publishingYear, price, cover);
    }
}
