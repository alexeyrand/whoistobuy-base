package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;
import ru.alexeyrand.whoistobuybase.services.Historical;

import java.util.ArrayList;
import java.util.List;

/**
 * Машина конечных состояний. Создается через Фабрику конечных состояний (BaseStateMachineFactory - базовый класс для фабрики).
 * Имеет возможность сохранять в базу данных историю изменения состояний сущностей с помощью сервиса, имплементирующего интерфейс Historical.
 * Создает граф(дерево) из состояний и переходов.
 * @param <S> Enum, описывающий возможные состояния сущности
 * @param <A> Enum, описывающий возможные действия (переходы между состояниями) сущности
 * @param <E> сущность, имеющая состояние
 *
 *
 * //TODO: сделать builder
 */
@Setter
@Getter
public class FinalStateMachine<S extends StateWithAction<A>, A extends ActionWithState<S>, E extends Stateful<S>> {
    private State<S, A> head;
    private List<S> alreadyPass = new ArrayList<>();
    private Historical<S, A> historicalService;
    private boolean isHistorical = false;

    public E moveToState(E entity, A action) {
        alreadyPass.clear();
        State<S, A> result = new State<>();
        S currentState = entity.getState();
        helper(head, currentState, result);
        S s = result.getState();

        if (s.getActionList().contains(action)) {
            S newState = action.getState();
            entity.setState(newState);
            if (isHistorical && historicalService != null) {
                historicalService.createHistory(currentState, newState, action);
            } else {
                System.out.println("Не определен сервис Historical");
            }
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
