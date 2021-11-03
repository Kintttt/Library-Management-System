package com.decagon.week3;


import com.decagon.week3.enums.Roles;
import com.decagon.week3.interfaces.Borrower;
import com.decagon.week3.models.Book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SchoolLibraryApp {

    private String implementation;
    private Map<String, String> configMap;
    private Map<Book, Borrower> borrowedBooks;
    private Library library;
    private Librarian librarian;
    private static Scanner scanner;


    public SchoolLibraryApp() {
        configMap = new HashMap<>();
    }

    public static void main(String[] args) {


        SchoolLibraryApp schoolLibraryApp = new SchoolLibraryApp();

        try {

            System.out.println("WELCOME TO TEMI'S SCHOOL LIBRARY SYSTEM");
            System.out.println();
            System.out.println();
            schoolLibraryApp.startApplication();
        }
         catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }


    private void startApplication() throws FileNotFoundException, InterruptedException {
        System.out.println("Loading configuration settings params...");
        Thread.sleep(3000);
        loadConfigurationParameters();
        System.out.println("Starting Dependency Injection...");
        Thread.sleep(2000);
        initDependencies();
    }


    private void loadConfigurationParameters() throws FileNotFoundException {

        scanner = new Scanner(new FileInputStream("/resources/src/app_config.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(!line.isEmpty()){
                String[] token = line.split("=");
                configMap.put(token[0], token[1]);
            }

        }
    }


    private void initDependencies() throws InterruptedException {

        System.out.println("Loading list of borrowed books...");
        Thread.sleep(3000);
        borrowedBooks = new HashMap<>();
        System.out.println("Loading Library...");
        Thread.sleep(3000);
        library = new Library();
        System.out.println("Instantiating the Librarian...");
        Thread.sleep(3000);
        librarian = new Librarian(configMap.get("librarian_name"), Roles.LIBRARIAN,borrowedBooks,library);

    }


}
