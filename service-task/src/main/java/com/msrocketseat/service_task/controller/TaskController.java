package com.msrocketseat.service_task.controller;

import com.msrocketseat.service_task.dto.TaskRequest;
import com.msrocketseat.service_task.dto.TaskResponse;
import com.msrocketseat.service_task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping("/create")
    public TaskResponse createTask(@RequestBody TaskRequest request) {
        return service.createTask(request);
    }
}
