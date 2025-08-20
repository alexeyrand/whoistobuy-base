package ru.alexeyrand.whoistobuybase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexeyrand.whoistobuybase.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, BaseRepository<User> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByTelephone(String telephone);
    boolean existsByChatId(Long chatId);
}
