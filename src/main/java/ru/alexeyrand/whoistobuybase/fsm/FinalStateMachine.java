package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class FinalStateMachine<S extends Enum<S>, A extends Enum<A>, E extends Stateful<S>> {
    private State<S, A> head;
    private Map<S, List<A>> actionMap;

    public S transfer(E entity, A action) {
        S currentState = getCurrentState(entity);
        List<A> actions = actionMap.get(currentState);

        return currentState;
    }


    public S getCurrentState(Stateful<S> entity) {
        return entity.getCurrentState();
    }

    private State<S, A> helper(State<S, A> node, S currentState) {
        if (node.getState() == currentState) {
            return node;
        }
        if (!node.getNodes().isEmpty()) {
            List<State<S, A>> nodes = node.getNodes();
            for (State<S, A> n : nodes) {
                helper(n, currentState);
            }

        }
        return null;
    }
}
