package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public abstract class BaseStateMachineFactory<S extends Enum<S>, A extends Enum<A>, V extends Stateful<S>> {
    private Integer value;

    // возвращает карту состояний, представляющую собой граф
    public abstract FinalStateMachine<S, A, V> createStateMachine();

    public abstract Map<S, List<A>> createActionMap();

}
