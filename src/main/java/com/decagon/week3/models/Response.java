package com.decagon.week3.models;

public class Response<T> {


    private final boolean isOperationSuccessFull;
    private final String  message;

    public T getData() {
        return data;
    }

    private T data;

    public Response(boolean isOperationSuccessFull, String message,T data) {
        this.isOperationSuccessFull = isOperationSuccessFull;
        this.message = message;
        this.data = data;
    }

    public boolean isOperationStatus() {
        return isOperationSuccessFull;
    }

    public String getMessage() {
        return message;
    }

}
