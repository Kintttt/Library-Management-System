package com.decagon.week3;

public class Request {


    private Borrower bookBorrower;
    private String bookNameToBorrow;

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
