package ru.alexeyrand.whoistobuybase.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ru.alexeyrand.whoistobuybase.entities.Health;
import ru.alexeyrand.whoistobuybase.enums.HealthStatus;


public abstract class HealthRestController {

    @GetMapping("/health/")
    public ResponseEntity<Health> getHealth() {
        final Health health = new Health();
        health.setStatus(HealthStatus.UP);
        return ResponseEntity.ok().body(health);
    }
}
