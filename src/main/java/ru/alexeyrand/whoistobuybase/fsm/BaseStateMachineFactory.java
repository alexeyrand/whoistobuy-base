package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;
import ru.alexeyrand.whoistobuybase.services.BaseService;
import ru.alexeyrand.whoistobuybase.services.Historical;


@Getter
@Setter
public abstract class BaseStateMachineFactory<S extends StateWithAction<A>, A extends ActionWithState<S>, E extends Stateful<S>> {

    Historical<S, A> historicalService;

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
     * Определяет возможность вести историю изменения состояния сущности в базе данных
     * */
    public void addHistory(Historical<S, A> historyService) {
        this.historicalService = historyService;
    }

    /**
     * Возвращает машину состояний - класс для работы с состояниями сущности
     * */
    public abstract FinalStateMachine<S, A, E> defineStateMachine();

    public abstract void init();

}
