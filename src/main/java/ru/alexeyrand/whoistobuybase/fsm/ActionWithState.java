package ru.alexeyrand.whoistobuybase.fsm;

import java.util.List;

public interface ActionWithState<T extends StateWithAction<?>> {
    T getState();
    void setState(T actionList);
}
