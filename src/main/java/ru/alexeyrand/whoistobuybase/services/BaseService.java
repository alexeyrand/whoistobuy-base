package ru.alexeyrand.whoistobuybase.services;


import org.springframework.transaction.annotation.Transactional;
import ru.alexeyrand.whoistobuybase.entities.BaseEntity;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Базовый сервис
 */
@Transactional
public abstract class BaseService<T extends BaseEntity> {

    public abstract BaseRepository<T> getRepository();

    public T save(T entity) {
        entity = beforeSave(entity);
        entity = getRepository().save(entity);
        return afterSave(entity);
    }

    public T findById(Long id) {
        return getRepository().findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public Long deleteById(Long id) {
        T entity = getRepository().findById(id).orElseThrow(NoSuchElementException::new);
        afterDelete(entity);
        getRepository().deleteById(id);
        beforeDelete(entity);
        return id;
    }



    public T beforeSave(T entity) {
        return entity;
    }
    public T afterSave(T entity) {
        return entity;
    }
    public T beforeDelete(T entity) {
        return entity;
    }
    public T afterDelete(T entity) {
        return entity;
    }
    public T controllerMethod(T entity) {
        return entity;
    }
}
