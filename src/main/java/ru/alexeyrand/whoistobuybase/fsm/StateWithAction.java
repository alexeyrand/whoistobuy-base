package ru.alexeyrand.whoistobuybase.fsm;

import java.util.List;

public interface StateWithAction<T extends ActionWithState<?>> {
    List<T> getActionList();
    void setActionList(List<T> actionList);
}
