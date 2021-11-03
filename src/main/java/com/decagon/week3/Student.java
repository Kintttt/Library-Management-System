package com.decagon.week3;

import com.decagon.week3.enums.Roles;
import com.decagon.week3.interfaces.Borrower;
import com.decagon.week3.interfaces.ResponseListener;
import com.decagon.week3.models.Request;

public class Student extends Person  implements Borrower {

    private final Librarian librarian;
    private ResponseListener responseListener;

    public Student(String name, Roles role,Librarian librarian){
        super(name, role);
        this.librarian = librarian;
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
        if( (this.role == Roles.SENIOR_STUDENT || this.role == Roles.JUNIOR_STUDENT )  && borrower.role == Roles.TEACHER){
           priority =-1;
        }

        if(this.role == Roles.SENIOR_STUDENT && borrower.role == Roles.JUNIOR_STUDENT){
          priority = 1;
        }

        if(this.role == Roles.SENIOR_STUDENT && borrower.role == Roles.SENIOR_STUDENT){
            priority = 0;
        }

        if(this.role == Roles.JUNIOR_STUDENT  && borrower.role ==Roles.JUNIOR_STUDENT){
            priority = 0;
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
