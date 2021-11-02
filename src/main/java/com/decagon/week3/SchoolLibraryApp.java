package com.decagon.week3;

import com.decagon.week3.enums.Roles;
import com.decagon.week3.models.Book;

public  class SchoolLibraryApp {

    private static Library schoolLibrary = null;
    private static Librarian librarain;

    public static String getImplementation() {
        return implementation;
    }

    private static  String implementation;

    public SchoolLibraryApp(){
        schoolLibrary = new Library();
        implementation = "";
    }

    public static Library getLibrary(){

        if(schoolLibrary == null){
            schoolLibrary = new Library();
            return schoolLibrary;
        }
        return schoolLibrary;

    }
    public static void main(String[] args) {
        librarain = new Librarian("Temi", Roles.LIBRARIAN);
        librarain.addBookToLibrary(librarain,new Book("General Mathematics","Temi"),10);




    }
}
