package com.decagon.week3;

import com.decagon.week3.enums.Roles;
import com.decagon.week3.models.Response;

import javax.management.relation.Role;

public class Teacher extends Person implements Borrower{


    private Librarian librarian;
    public Teacher(String name, Roles role,Librarian librarian){
        super(name,role);
        this.librarian = librarian ;
    }

    @Override
    public Response borrowBook(Person person, String bookName) {

    }

    @Override
    public Response returnBook(Person person, String bookName) {
        return null;
    }
}
