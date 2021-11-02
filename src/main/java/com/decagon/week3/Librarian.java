package com.decagon.week3;

import com.decagon.week3.enums.Roles;
import com.decagon.week3.models.Book;
import com.decagon.week3.models.Response;


import java.util.*;

public class Librarian extends Person {

    private final Map<Book, Borrower> listOfBorrowedBooks;
    private final Queue<Request> listOfBorrowers;
    private final PriorityQueue<Request> priorityBasedBorrowers;

    public Librarian(
            String name,
            Roles role,
            Map<Book, Borrower> listOfBorrowedBooks,
            Queue<Request> borrowers,
            PriorityQueue<Request> priorityBasedBorrowers
    ) {
        super(name, role);
        this.listOfBorrowedBooks = listOfBorrowedBooks;
        this.listOfBorrowers = borrowers;
        this.priorityBasedBorrowers = priorityBasedBorrowers;
    }

    public Response addBookToLibrary(Person person, Book book, int copies) {


        Response operationResponse;

        if (person instanceof Librarian) {
            Library schoolLibrary = SchoolLibraryApp.getLibrary();

            if (schoolLibrary.addNewBookToLibrary(book, copies)) {
                operationResponse = new Response(true, "Book Was added successfully", null);
            } else {
                operationResponse = new Response(false, "Book already exist in the Library", null);
            }

            return operationResponse;
        } else {
            return new Response(false, "You do not have the privilege to add books to Library ", null);
        }

    }


    public Response issueBook(Request bookRequest) {

        if (Objects.equals(SchoolLibraryApp.getImplementation(), "normal")) {

            if (listOfBorrowers.size() <= 10) {

                listOfBorrowers.add(bookRequest);
            }
            else {

                Request request = listOfBorrowers.poll();
                while (request != null) {
                    Response response = startIssuingBooks(request.getBookNameToBorrow(), request.getBookBorrower());
                    if(!response.isOperationStatus()){
                        return  response;
                    }
                    request = listOfBorrowers.poll();
                }

            }
        } else {

        }

    }


    public Response returnBook(Request bookRequest) {


//        if(listOfBorrowedBooks.get()){
//
//        }
//
//        if( listOfBorrowedBooks.get(response.getData()) == borrower){
//            return new Response(false,"You have already borrowed a book",null);
//        }

    }


    private Response startIssuingBooks(String bookName, Borrower borrower) {
        Response<Book> response = SchoolLibraryApp.getLibrary().checkIfBookExist(bookName);

        if (response.isOperationStatus()) {

            if (listOfBorrowedBooks.get(response.getData()) == borrower) {
                return new Response(false, "You have already borrowed " + bookName, null);
            } else {
                listOfBorrowedBooks.put(response.getData(), borrower);
                return new Response(true, "You have been successfully borrowed " + bookName, null);
            }
        } else {
            return new Response(false, "There is no such book in the library", null);
        }

    }


}
