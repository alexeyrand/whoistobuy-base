package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class FinalStateMachine<S extends StateWithAction<A>, A extends ActionWithState<S>, E extends Stateful<S>> {
    private State<S, A> head;
    private Map<S, List<A>> actionMap;
    private List<S> alreadyPass = new ArrayList<>();

    public FinalStateMachine(InitializationStateAndAction initializationStateAndAction) {
        initializationStateAndAction.init();
    }

    public E moveToState(E entity, A action) {
        State<S, A> result = new State<>();
        S currentState = entity.getState();
        helper(head, currentState, result);
        S s = result.getState();

        if (s.getActionList().contains(action)) {
            S newState = action.getState();
            entity.setState(newState);
        }
        return entity;
    }


    private void helper(State<S, A> node, S currentState, State<S, A> result) {
        if (node.getState() == currentState) {
            result.setState(node.getState());
        }
        alreadyPass.add(node.getState());
        if (node.getNodes() != null && !node.getNodes().isEmpty() && result != node) {
            List<State<S, A>> nodes = node.getNodes();
            for (State<S, A> n : nodes) {
                if (!alreadyPass.contains(n.getState()))
                    helper(n, currentState, result);
            }
        }
    }
}
