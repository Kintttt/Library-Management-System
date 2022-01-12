package com.decagon.week3;

import com.decagon.week3.enums.Roles;
import com.decagon.week3.interfaces.Borrower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {


    static Borrower borrower = new Student(
            "Daro",
            Roles.TEACHER,
            new Librarian(
                    "Temi",
                    Roles.LIBRARIAN,
                    null,
                    null)
    );

    @BeforeEach
    void setUp() {
        borrower.addResponseListener(response -> {});
    }

    @Test
    void getResponseListener() {
        assertNotNull(borrower.getResponseListener());
    }
}