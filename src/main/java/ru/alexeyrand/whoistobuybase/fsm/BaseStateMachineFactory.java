package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alexeyrand.whoistobuybase.services.Historical;


@Getter
@Setter
@Component
public abstract class BaseStateMachineFactory<S extends StateWithAction<A>, A extends ActionWithState<S>, E extends Stateful<S>> {

    @Autowired(required = false)
    private Historical<S, A> historicalService;

    public BaseStateMachineFactory() {

    }

    public FinalStateMachine<S, A, E> createStateMachine() {
        init();
        FinalStateMachine<S, A, E> fsm = defineStateMachine();

        if (historicalService != null)
            fsm.setHistoricalService(historicalService);
        return fsm;
    }

    /**
     * Возвращает машину состояний - класс для работы с состояниями сущности
     * */
    public abstract FinalStateMachine<S, A, E> defineStateMachine();

    public abstract void init();

}
