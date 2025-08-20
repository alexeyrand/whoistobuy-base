package ru.alexeyrand.whoistobuybase.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.alexeyrand.whoistobuybase.enums.HealthStatus;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Health {
    private HealthStatus status;
}
