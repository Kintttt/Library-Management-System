package com.decagon.week3;

import com.decagon.week3.enums.Roles;
import com.decagon.week3.interfaces.Borrower;
import com.decagon.week3.interfaces.ResponseListener;
import com.decagon.week3.models.Request;

public class Teacher extends Person implements Borrower {


    private final Librarian librarian;
    private ResponseListener responseListener;
    private int priority;
    public Teacher(String name, Roles role,Librarian librarian){
        super(name,role);
        if(role == Roles.TEACHER){
            this.priority = 1;
        }
        this.librarian = librarian ;
    }



    @Override
    public void borrowBook(String bookName) {

       librarian.requestForBook(new Request(this,bookName,priority));


    }

    @Override
    public void returnBook(String bookName) {
      librarian.returnBook(new Request(this,bookName,priority));
    }




    public void addResponseListener(ResponseListener listener){
        this.responseListener = listener;
    }

    @Override
    public ResponseListener getResponseListener() {
        return this.responseListener;
    }


}
