package ru.alexeyrand.whoistobuybase.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexeyrand.whoistobuybase.entities.User;
import ru.alexeyrand.whoistobuybase.fsm.FinalStateMachine;
//import ru.alexeyrand.whoistobuybase.fsm.impl.UserFactory;
import ru.alexeyrand.whoistobuybase.repositories.BaseRepository;
import ru.alexeyrand.whoistobuybase.repositories.UserRepository;


/**
 * Сервис для работы с Пользователями
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserService extends BaseService<User> {


//    @PostConstruct
//    private void createMap() {
//        UserFactory userFactory = new UserFactory();
//        FinalStateMachine<UserState, User> finalStateMachine = userFactory.createStateMap();
//    }

    private final UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByTelephone(String telephone) {
        return userRepository.existsByTelephone(telephone);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByChatId(Long chatId) {
        return userRepository.existsByChatId(chatId);
    }

    @Override
    public BaseRepository<User> getRepository() {
        return userRepository;
    }
}
