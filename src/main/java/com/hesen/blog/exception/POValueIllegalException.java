package com.hesen.blog.exception;

public class POValueIllegalException extends RuntimeException {
    public POValueIllegalException() {
        super();
    }

    public POValueIllegalException(String message) {
        super(message);
    }

    public POValueIllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    public POValueIllegalException(Throwable cause) {
        super(cause);
    }
}
