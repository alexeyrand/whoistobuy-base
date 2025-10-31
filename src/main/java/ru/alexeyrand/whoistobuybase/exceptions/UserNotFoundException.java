package ru.alexeyrand.whoistobuybase.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserNotFoundException extends LogicalException {
    public String username;
    public UserNotFoundException(String username) {
        super("Пользователь '" + username + "' не найден", HttpStatus.NOT_FOUND);
        this.username = username;
    }
}
