//package ru.alexeyrand.whoistobuybase.fsm.impl;
//
//import ru.alexeyrand.whoistobuybase.entities.User;
//import ru.alexeyrand.whoistobuybase.fsm.BaseStateMachineFactory;
//import ru.alexeyrand.whoistobuybase.fsm.State;
//import ru.alexeyrand.whoistobuybase.fsm.FinalStateMachine;
//import ru.alexeyrand.whoistobuybase.fsm.state.UserState;
//
//import java.util.List;
//
//public class UserFactory extends BaseStateMachineFactory<UserState, User> {
//
//    @Override
//    public FinalStateMachine<UserState, User> createStateMachine() {
//        FinalStateMachine<UserState, User> finalStateMachine = new FinalStateMachine<>();
//        State<UserState> state1 = new State<>();
//        state1.setState(UserState.IDLE);
//        State<UserState> state2 = new State<>();
//        state2.setState(UserState.REVIEW);
//        state1.setNodes(List.of(state2));
//        finalStateMachine.setState(state1);
//        return finalStateMachine;
//    }
//}
