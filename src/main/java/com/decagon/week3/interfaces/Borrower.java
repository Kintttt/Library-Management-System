package com.decagon.week3.interfaces;

import com.decagon.week3.Person;

public interface Borrower {


    public void borrowBook(String bookName);
    public void returnBook(String bookName);
    public void addResponseListener(ResponseListener listener);
    public ResponseListener getResponseListener();
}
