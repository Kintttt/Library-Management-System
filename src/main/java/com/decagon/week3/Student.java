package com.decagon.week3;

import com.decagon.week3.enums.Roles;
import com.decagon.week3.models.Response;

public class Student extends Person  implements Borrower {

    private Librarian librarian;
    public Student(String name, Roles role,Librarian librarian){
        super(name, role);
        this.librarian = librarian;
    }

    @Override
    public Response borrowBook(Person person, String bookName) {
        return null;
    }

    @Override
    public Response returnBook(Person person, String bookName) {
        return null;
    }
}
