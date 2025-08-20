package ru.alexeyrand.whoistobuybase.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

/**
 * Базовая сущность приложения witb
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID")
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "TITLE")
    private String title;
    @CreatedDate
    @Column(name = "CREATED_AT")
    private Date createdAt;
    @LastModifiedDate
    @Column(name = "UPDATE_AT")
    private Date updatedAt;
}
