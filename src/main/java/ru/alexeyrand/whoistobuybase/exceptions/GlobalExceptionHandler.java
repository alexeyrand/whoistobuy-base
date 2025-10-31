package ru.alexeyrand.whoistobuybase.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Data
    @AllArgsConstructor
    public static class ErrorResponse {
        private String message;
        private String errorType;
        private LocalDateTime timestamp;
        private String path;

        public ErrorResponse(String message, String errorType, String path) {
            this.message = message;
            this.errorType = errorType;
            this.path = path;
            this.timestamp = LocalDateTime.now();
        }
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(
            NoSuchElementException ex, WebRequest request) {

        log.info("Сущность не найдена в базе данных: {}", ex.getMessage());

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(ex.getMessage(), "NOT_FOUND_ERROR",
                        request.getDescription(false)));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundException(
            UserNotFoundException ex, WebRequest request) {

        log.info("Пользователь \"{}\" не найден: {}", ex.getUsername(), ex.getMessage());

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(ex.getMessage(), ex.getHttpStatus().name(),
                        request.getDescription(false)));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(
            MethodArgumentNotValidException ex, WebRequest request) {

        log.info("Не валидное значение переменной \"{}\": {}", ex.getParameter().getParameter().getName(), ex.getMessage());

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(ex.getMessage(), ex.getStatusCode().toString(),
                        request.getDescription(false)));
    }

}
