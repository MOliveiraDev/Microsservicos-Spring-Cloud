package com.msrocketseat.service_task.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "task_tb")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String email;

    @Column(name = "expiration_date")
    private LocalDateTime dueDate;

    private Boolean notified;
}
