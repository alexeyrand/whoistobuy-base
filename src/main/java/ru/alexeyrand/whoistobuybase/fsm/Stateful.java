package ru.alexeyrand.whoistobuybase.fsm;

import jakarta.persistence.Entity;

public interface Stateful<T extends Enum<T>> {
    void setCurrentState(T state);
    T getCurrentState();
}
