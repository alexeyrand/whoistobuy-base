package ru.alexeyrand.whoistobuybase.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexeyrand.whoistobuybase.entities.BaseEntity;
import ru.alexeyrand.whoistobuybase.exceptions.IHandleException;
import ru.alexeyrand.whoistobuybase.exceptions.LogicalException;
import ru.alexeyrand.whoistobuybase.services.BaseService;

import java.util.List;

@AllArgsConstructor
public abstract class BaseRestController<T extends BaseEntity> implements IHandleException {

    public abstract BaseService<T> getService();

    @GetMapping(value = "/")
    public ResponseEntity<List<T>> getAll() {
        List<T> entities = getService().findAll();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<T> getEntity(@PathVariable("id") Long id) {
        T entity = getService().findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<T> create(@RequestBody T dto) {
        T entity = getService().save(dto);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public Long delete(@PathVariable("id") Long id) {
        return getService().deleteById(id);
    }

    @Override
    @ExceptionHandler
    public ResponseEntity<String> handleLogicalException(LogicalException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }
}
