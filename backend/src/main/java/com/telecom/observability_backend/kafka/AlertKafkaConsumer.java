package com.telecom.observability_backend.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telecom.observability_backend.model.AlertMessage;
import com.telecom.observability_backend.service.AlertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AlertKafkaConsumer {

    private final AlertService alertService;
    private final ObjectMapper objectMapper;

    @KafkaListener(
        topics = "telecom-alerts",
        groupId = "observability-group"
    )
    public void consume(String message) {
        try {
            AlertMessage alert = objectMapper.readValue(message, AlertMessage.class);
            log.info("[Kafka] Received alert: {} - {}", alert.getPriority(), alert.getMessage());
            alertService.sendAlert(alert);
        } catch (Exception e) {
            log.error("[Kafka] Failed to deserialize message: {}", message, e);
        }
    }
}