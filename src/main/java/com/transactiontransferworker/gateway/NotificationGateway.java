package com.transactiontransferworker.gateway;

import com.transactiontransferworker.gateway.dto.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "notification-gateway", url = "${gateway.url}")
public interface NotificationGateway {

    @GetMapping("/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6")
    @ResponseBody
    ResponseEntity<NotificationResponse> sendNotificationRequest();

}
