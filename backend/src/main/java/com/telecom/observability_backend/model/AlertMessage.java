package com.telecom.observability_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlertMessage {

    private String id;
    private String timestamp;
    private Priority priority;
    private String component;
    private String message;
    private Status status;

    public enum Priority {
        P1, P2, P3
    }

    public enum Status {
        OPEN, ACK, RESOLVED
    }

    public static AlertMessage create(Priority priority, String component, String message) {
        return AlertMessage.builder()
                .id(UUID.randomUUID().toString())
                .timestamp(Instant.now().toString())
                .priority(priority)
                .component(component)
                .message(message)
                .status(Status.OPEN)
                .build();
    }
}