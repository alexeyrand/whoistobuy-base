package ru.alexeyrand.whoistobuybase.services;

import ru.alexeyrand.whoistobuybase.fsm.ActionWithState;
import ru.alexeyrand.whoistobuybase.fsm.StateWithAction;

public interface Historical<S extends StateWithAction<A>, A extends ActionWithState<S>> {

    default void createHistory(S beforeState, S afterState, A action) {
        System.out.println("В микросервисе не найден сервис, реализующий интерфейс Historical");
    }

}
