package ru.alexeyrand.whoistobuybase.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import ru.alexeyrand.whoistobuybase.fsm.Stateful;
import ru.alexeyrand.whoistobuybase.fsm.state.UserState;

/**
 * Сущность пользователя
 */
@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User extends BaseEntity implements Stateful<UserState> {
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEPHONE")
    private String telephone;
    @Column(name = "PHOTO")
    private String photo;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "CHAT_ID")
    private Long chatId;
    @Column(name = "STATE")
    private UserState state = UserState.IDLE;

    @Override
    public UserState getCurrentState() {
        return state;
    }

    @Override
    public void setCurrentState(UserState state) {
        this.state = state;
    }
}


