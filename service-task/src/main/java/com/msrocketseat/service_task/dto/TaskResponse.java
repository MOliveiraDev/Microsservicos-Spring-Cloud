package com.msrocketseat.service_task.dto;

import java.time.LocalDateTime;

public record TaskResponse(String title, String status, String email, LocalDateTime dueDate) {
}
