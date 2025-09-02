package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;
import ru.alexeyrand.whoistobuybase.services.BaseService;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public abstract class BaseStateMachineFactory<S extends StateWithAction<A>, A extends ActionWithState<S>, E extends Stateful<S>> {

    public BaseStateMachineFactory(InitializationStateAndAction initializationStateAndAction) {
        initializationStateAndAction.init();
    }

    /**
     * Возвращает машину состояний - класс для работы с состояниями сущности
     * */
    public abstract FinalStateMachine<S, A, E> createStateMachine();

}
