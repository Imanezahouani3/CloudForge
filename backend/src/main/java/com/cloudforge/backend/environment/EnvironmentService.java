package com.cloudforge.backend.environment;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class EnvironmentService {

    private final Map<UUID, EnvironmentRequest> environments = new ConcurrentHashMap<>();

    public EnvironmentRequest create(CreateEnvironmentRequest request) {
        EnvironmentRequest environment = new EnvironmentRequest(request.repositoryUrl());
        environments.put(environment.getId(), environment);
        return environment;
    }

    public EnvironmentRequest findById(UUID id) {
        EnvironmentRequest environment = environments.get(id);
        if (environment == null) {
            throw new EnvironmentNotFoundException(id);
        }
        return environment;
    }
}