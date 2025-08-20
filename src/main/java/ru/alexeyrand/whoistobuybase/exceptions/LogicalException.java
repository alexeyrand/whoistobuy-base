package ru.alexeyrand.whoistobuybase.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LogicalException extends RuntimeException {
    HttpStatus httpStatus;
    static final String LOGICAL_EXCEPTION = "LogicalException";
    public LogicalException(String message) {
        super(message);
    }
    public LogicalException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
