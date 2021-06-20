package com.hesen.blog.exception;

public class DaoFailException extends RuntimeException {

    public DaoFailException() {
        super();
    }

    public DaoFailException(String message) {
        super(message);
    }

    public DaoFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoFailException(Throwable cause) {
        super(cause);
    }
}
