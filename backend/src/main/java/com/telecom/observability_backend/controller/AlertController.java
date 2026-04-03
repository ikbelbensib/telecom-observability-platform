package com.telecom.observability_backend.controller;

import com.telecom.observability_backend.model.AlertMessage;
import com.telecom.observability_backend.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    // WebSocket — reçoit un message du client et le broadcast
    @MessageMapping("/alerts.send")
    @SendTo("/topic/alerts")
    public AlertMessage handleAlert(AlertMessage alert) {
        return alert;
    }

    // REST — trigger manuel d'une alerte P1
    @PostMapping("/api/alerts/trigger")
    public AlertMessage triggerAlert(@RequestBody AlertMessage alert) {
        alertService.sendAlert(alert);
        return alert;
    }

    // REST — health check
    @GetMapping("/api/health")
    public String health() {
        return "OK";
    }
}