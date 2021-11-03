package com.decagon.week3;

import com.decagon.week3.enums.Roles;
import com.decagon.week3.interfaces.Borrower;
import com.decagon.week3.interfaces.ResponseListener;
import com.decagon.week3.models.Request;

public class Teacher extends Person implements Borrower {


    private Librarian librarian;
    private ResponseListener responseListener;
    public Teacher(String name, Roles role,Librarian librarian){
        super(name,role);
        this.librarian = librarian ;
    }

    @Override
    public void borrowBook(String bookName) {

       librarian.requestForBook(new Request(this,bookName));

    }

    @Override
    public void returnBook(String bookName) {
//        librarian.returnBook(new Request(this,bookName));
    }

    @Override
    public int compareTo(Person borrower) {
        int priority = 0;
       if(borrower.role == Roles.SENIOR_STUDENT || borrower.role == Roles.JUNIOR_STUDENT){
           priority = 1;
       }
       return priority;
    }


    public void addResponseListener(ResponseListener listener){
        this.responseListener = listener;
    }

    @Override
    public ResponseListener getResponseListener() {
        return this.responseListener;
    }


}
