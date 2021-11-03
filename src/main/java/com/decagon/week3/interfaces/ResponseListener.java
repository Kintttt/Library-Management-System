package com.decagon.week3.interfaces;

import com.decagon.week3.models.Book;
import com.decagon.week3.models.Response;

public interface ResponseListener {

    public void onResponse(Response<Book> response);
}
