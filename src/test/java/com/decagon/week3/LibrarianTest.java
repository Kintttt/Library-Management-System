package com.decagon.week3;

import com.decagon.week3.models.Book;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {


    static Library library;

    @BeforeAll
    static void setUp() {
        library = new Library();
    }

    @Test
    void addBookToLibrary() {
        assertTrue(library.addNewBookToLibrary(new Book("Mathematics","Temi"),10));
    }
}