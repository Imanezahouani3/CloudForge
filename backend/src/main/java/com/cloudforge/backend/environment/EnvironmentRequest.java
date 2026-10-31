package com.cloudforge.backend.environment;

import java.time.Instant;
import java.util.UUID;

public class EnvironmentRequest {

    private final UUID id;
    private final String repositoryUrl;
    private EnvironmentStatus status;
    private final Instant createdAt;

    public EnvironmentRequest(String repositoryUrl) {
        this.id = UUID.randomUUID();
        this.repositoryUrl = repositoryUrl;
        this.status = EnvironmentStatus.PENDING;
        this.createdAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public EnvironmentStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setStatus(EnvironmentStatus status) {
        this.status = status;
    }
}
