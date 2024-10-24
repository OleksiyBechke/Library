package org.example.app;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book == null || books.contains(book)) {
            throw new IllegalArgumentException("Invalid book: null or already exists.");
        }
        books.add(book);
    }

    public boolean removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Invalid book: null.");
        }

        return books.remove(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public int getBookCount() {
        return books.size();
    }
}
