package com.decagon.week3;

import com.decagon.week3.models.Book;
import com.decagon.week3.models.Response;

import java.util.*;

public class Library {
    private final Map<Book, Integer> libraryBooks;

    public Library() {
        libraryBooks = new HashMap<>();
    }


    public boolean addNewBookToLibrary(Book book, int copies) {

        if (libraryBooks.containsKey(book))
            return false;
        else {
            libraryBooks.put(book, copies);
            return true;
        }
    }


    public Response<Book> getBook(String bookName) {
        return checkIfBookExist(bookName);
    }

    public Response addBookCopies(String bookName, int copiesToAdd) {

        Response<Book> response = checkIfBookExist(bookName);
        if (response.isOperationStatus()) {

            libraryBooks.put(response.getData(), (libraryBooks.get(response.getData()) + copiesToAdd));
            return new Response(true, "Copies of books added", null);

        } else {
            return new Response(false, "No such book exist", null);
        }
    }


    public Response<Book> checkIfBookExist(String bookName) {
        for (Book book : libraryBooks.keySet()) {
            if (Objects.equals(book.getName(), bookName) && libraryBooks.get(book.getName()) > 0) {
                libraryBooks.put(book, libraryBooks.get(book.getName()) - 1);
                return new Response<>(true, "Book Exist", book);
            }
        }
        return new Response<>(false, "Book Does Not Exist", null);
    }
}
