package com.msrocketseat.service_task.dto;

import java.time.LocalDateTime;

public record TaskRequest(String title, String email, LocalDateTime dueDate, Boolean notified) {
}
