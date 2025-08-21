package ru.alexeyrand.whoistobuybase.fsm;

import lombok.Getter;
import lombok.Setter;
import ru.alexeyrand.whoistobuybase.fsm.state.Action;

import java.util.List;

@Getter
@Setter
public class State<S extends Enum<S>, A extends Enum<A>> {
    private S state;
    private List<A> actions;
    private List<State<S, A>> nodes;
}
