package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class State<S extends StateWithAction<?>, A extends ActionWithState<?>> {
    private S state;
    private List<A> actions;
    private List<State<S, A>> nodes;
}
