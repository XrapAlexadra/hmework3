package com.github.xrapalexandra.exception;

public class BookExceptoin extends Exception{

    public BookExceptoin() {
    }

    public BookExceptoin(String message) {
        super(message);
    }

    public BookExceptoin(String message, Throwable throwable) {
        super(message, throwable);
    }

    public BookExceptoin(Throwable throwable) {
        super(throwable);
    }
}
