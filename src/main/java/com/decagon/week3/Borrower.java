package com.decagon.week3;

import com.decagon.week3.models.Response;

public interface Borrower {

    public Response borrowBook(Person person, String bookName);
    public Response returnBook(Person person,String bookName);
}
