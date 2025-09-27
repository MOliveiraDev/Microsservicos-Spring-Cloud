package com.msrocketseat.service_task.config.client;

import com.msrocketseat.service_task.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-notification")
@Component
public interface INotificationClient {

    @PostMapping("/notification")
    void sendNotification(@RequestBody NotificationRequest request);
}
