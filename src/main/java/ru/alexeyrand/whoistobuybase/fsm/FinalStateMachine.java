package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FinalStateMachine<S extends Enum<S>, A extends Enum<A>, V extends Stateful<S>> {
    private State<S, A> state;

    private S transfer(V entity, A action) {
        S currentState = entity.getCurrentState();

        return currentState;
    }


    private Enum<S> getCurrentState(Stateful<S> entity) {
        return entity.getCurrentState();
    }
}
