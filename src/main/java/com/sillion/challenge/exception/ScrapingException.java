package com.sillion.challenge.exception;

public class ScrapingException extends RuntimeException {

    public ScrapingException(String msg) {
        super(msg);
    }

    public ScrapingException(String msg, Throwable cause) {
        super(msg, cause);
    }
}