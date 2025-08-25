package ru.alexeyrand.whoistobuybase.fsm;

public interface Stateful<T extends StateWithAction<?>> {
    void setState(T state);
    T getState();
}
