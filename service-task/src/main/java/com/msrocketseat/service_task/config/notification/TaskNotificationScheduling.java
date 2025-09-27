package com.msrocketseat.service_task.config.notification;

import com.msrocketseat.service_task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskNotificationScheduling {

    private final TaskService service;

    @Scheduled(fixedRate = 360000 * 24)
    public void checkAndNotifiyTask() {
        service.sendNotificationForDueTask();
    }
}
