package com.decagon.week3.models;

import com.decagon.week3.interfaces.Borrower;

public class Request {


    private final Borrower bookBorrower;
    private final String bookNameToBorrow;

    public Borrower getBookBorrower() {
        return bookBorrower;
    }

    public String getBookNameToBorrow() {
        return bookNameToBorrow;
    }

    public Request(Borrower bookBorrower, String bookNameToBorrow) {
        this.bookBorrower = bookBorrower;
        this.bookNameToBorrow = bookNameToBorrow;
    }



}
