package com.msrocketseat.service_task.service;


import com.msrocketseat.service_task.config.client.INotificationClient;
import com.msrocketseat.service_task.domain.TaskEntity;
import com.msrocketseat.service_task.dto.NotificationRequest;
import com.msrocketseat.service_task.dto.TaskRequest;
import com.msrocketseat.service_task.dto.TaskResponse;
import com.msrocketseat.service_task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final INotificationClient notificationClient;

    public TaskResponse createTask(TaskRequest request) {
        TaskEntity task = new TaskEntity();
        task.setTitle(request.title());
        task.setEmail(request.email());
        task.setDueDate(request.dueDate());
        task.setNotified(false);

        return ToResponseDto(repository.save(task));
    }

    public void sendNotificationForDueTask() {
        LocalDateTime deadLine = LocalDateTime.now().plusDays(1);
        List<TaskEntity> tasks = repository.findTasksDueWithinDeadline(deadLine);
        for (TaskEntity task : tasks) {
            NotificationRequest request = new NotificationRequest(
                "Sua tarefa: " + task.getTitle() + " está prestes a se vencer!",
                task.getEmail()
            );
            notificationClient.sendNotification(request);
            task.setNotified(true);
            repository.save(task);
        }
    }

    public TaskResponse ToResponseDto(TaskEntity task) {
        return new TaskResponse(
                task.getTitle(),
                task.getEmail(),
                task.getNotified() ? "NOTIFIED" : "PENDING",
                task.getDueDate()
        );
    }
}
