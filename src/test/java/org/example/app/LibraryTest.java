package org.example.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Book1", "Author1");
        book2 = new Book("Book2", "Author2");
    }

    @Test
    @DisplayName("Test adding a book to the library")
    public void testAddBook() {
        library.addBook(book1);
        library.addBook(book2);
        assertTrue(library.getBooks().contains(book1));
        assertTrue(library.getBooks().contains(book2));
    }

    @Test
    @DisplayName("Test adding a duplicate book")
    public void testAddDuplicateBook() {
        library.addBook(book1);
        assertThrows(IllegalArgumentException.class, () -> library.addBook(book1), "No exception.");
    }

    @Test
    @DisplayName("Test adding a null book")
    public void testAddNullBook() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null), "No exception.");
    }

    @Test
    @DisplayName("Test removing an existing book from the library")
    public void testRemoveBook() {
        library.addBook(book1);
        assertTrue(library.removeBook(book1));
        assertFalse(library.getBooks().contains(book1));
    }

    @Test
    @DisplayName("Test removing a non-existent book")
    public void testRemoveNonExistentBook() {
        assertFalse(library.removeBook(book1));
        assertFalse(library.getBooks().contains(book1));
    }

    @Test
    @DisplayName("Test removing a null book")
    public void testRemoveNullBook() {
        assertThrows(IllegalArgumentException.class, () -> library.removeBook(null));
    }

    @Test
    @DisplayName("Test retrieving all books from the library")
    public void testGetBooks() {
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.getBooks().size());
    }

    @Test
    @DisplayName("Test getting the total book count")
    public void testGetBookCount() {
        assertEquals(0, library.getBookCount());
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
        library.addBook(book2);
        assertEquals(2, library.getBookCount());
    }

    @AfterEach
    void tearDown() {
        library = null;
        book1 = null;
        book2 = null;
    }
}