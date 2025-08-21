package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public abstract class BaseStateMachineFactory<S extends Enum<S>, A extends Enum<A>, E extends Stateful<S>> {
    private Integer value;

    /**
     * Возвращает машину состояний - класс для работы с состояниями сущности
     * */
    public abstract FinalStateMachine<S, A, E> createStateMachine();

    /**
     * Возвращает карту состояний, представляющую собой граф из состояний и действий
     * */
    public abstract Map<S, List<A>> createActionMap();

}
