package ru.alexeyrand.whoistobuybase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.alexeyrand.whoistobuybase.repositories.UserRepository;
import ru.alexeyrand.whoistobuybase.services.UserService;

@Configuration
@EnableJpaRepositories(basePackages = {"ru.alexeyrand.whoistobuybase.repositories"})
public class BaseAutoConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

}
