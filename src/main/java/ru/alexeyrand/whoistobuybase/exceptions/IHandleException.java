package ru.alexeyrand.whoistobuybase.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface IHandleException {
    ResponseEntity<?> handleLogicalException(LogicalException e);
}
