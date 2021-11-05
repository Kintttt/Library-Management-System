package com.decagon.week3;

import com.decagon.week3.enums.Roles;
import com.decagon.week3.interfaces.Borrower;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    static Borrower borrower = new Student(
            "Temi",
                    Roles.SENIOR_STUDENT,
                      new Librarian(
                    "Temi",
                    Roles.LIBRARIAN,
                    null,
                    null)
             );

    @BeforeAll
    static void setUp() {
        borrower.addResponseListener(response -> {});
    }

    @Test
    void getResponseListener() {

        assertNotNull(borrower.getResponseListener());

    }
}