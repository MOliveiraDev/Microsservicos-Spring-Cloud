package com.msrocketseat.service_notification.controller;

import com.msrocketseat.service_notification.dto.NotificationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @PostMapping
    public ResponseEntity<Object> sendNotification(@RequestBody NotificationRequest notificationRequest) {
        System.out.println(notificationRequest.message());
        return ResponseEntity.ok().build();
    }
}
