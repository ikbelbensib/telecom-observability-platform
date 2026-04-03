package com.telecom.observability_backend.service;

import com.telecom.observability_backend.model.AlertMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableScheduling
public class AlertService {

    private final SimpMessagingTemplate messagingTemplate;
    private final Random random = new Random();

    private static final List<String> COMPONENTS = List.of(
            "CRM", "BILLING", "PROVISIONING", "CORE", "NETWORK", "ESIM", "VoLTE"
    );

    private static final List<String> P1_MESSAGES = List.of(
            "SERVICE_DOWN — node unreachable",
            "OUTAGE detected on MSC cluster",
            "CORE_FAILURE — failover initiated",
            "SLA_BREACH — critical threshold exceeded"
    );

    private static final List<String> P2_MESSAGES = List.of(
            "HIGH_LATENCY — avg response > 3000ms",
            "TIMEOUT on payment gateway",
            "PROVISIONING_FAIL for MSISDN",
            "DEGRADED service on gateway"
    );

    private static final List<String> P3_MESSAGES = List.of(
            "Slow response detected",
            "Queue depth elevated",
            "Minor configuration drift detected"
    );

    @Scheduled(fixedRate = 5000)
    public void generateAlert() {
        AlertMessage alert = buildRandomAlert();
        log.info("[AlertService] Broadcasting: {} - {}", alert.getPriority(), alert.getMessage());
        messagingTemplate.convertAndSend("/topic/alerts", alert);
    }

    private AlertMessage buildRandomAlert() {
        String component = COMPONENTS.get(random.nextInt(COMPONENTS.size()));
        int roll = random.nextInt(10);

        if (roll < 2) {
            return AlertMessage.create(
                    AlertMessage.Priority.P1,
                    component,
                    P1_MESSAGES.get(random.nextInt(P1_MESSAGES.size()))
            );
        } else if (roll < 6) {
            return AlertMessage.create(
                    AlertMessage.Priority.P2,
                    component,
                    P2_MESSAGES.get(random.nextInt(P2_MESSAGES.size()))
            );
        } else {
            return AlertMessage.create(
                    AlertMessage.Priority.P3,
                    component,
                    P3_MESSAGES.get(random.nextInt(P3_MESSAGES.size()))
            );
        }
    }

    public void sendAlert(AlertMessage alert) {
        messagingTemplate.convertAndSend("/topic/alerts", alert);
    }
}