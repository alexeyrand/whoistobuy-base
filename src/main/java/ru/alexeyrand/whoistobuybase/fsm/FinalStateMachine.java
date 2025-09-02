package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;
import ru.alexeyrand.whoistobuybase.entities.BaseEntity;
import ru.alexeyrand.whoistobuybase.services.BaseService;
import ru.alexeyrand.whoistobuybase.services.Historical;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class FinalStateMachine<S extends StateWithAction<A>, A extends ActionWithState<S>, E extends Stateful<S>> {
    private State<S, A> head;
    private List<S> alreadyPass = new ArrayList<>();
    private Historical<S, A> historicalService;

    public E moveToState(E entity, A action) {
        alreadyPass.clear();
        State<S, A> result = new State<>();
        S currentState = entity.getState();
        helper(head, currentState, result);
        S s = result.getState();

        if (s.getActionList().contains(action)) {
            S newState = action.getState();
            entity.setState(newState);
            historicalService.createHistory(currentState, newState, action);
        }
        return entity;
    }

    private void helper(State<S, A> node, S currentState, State<S, A> result) {
        if (node.getState() == currentState) {
            result.setState(node.getState());
        }
        alreadyPass.add(node.getState());
        if (node.getNodes() != null && !node.getNodes().isEmpty() && result.getState() != node.getState()) {
            List<State<S, A>> nodes = node.getNodes();
            for (State<S, A> n : nodes) {
                if (!alreadyPass.contains(n.getState()))
                    helper(n, currentState, result);
            }
        }
    }
}
