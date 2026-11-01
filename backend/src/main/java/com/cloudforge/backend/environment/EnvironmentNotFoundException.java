package com.cloudforge.backend.environment;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnvironmentNotFoundException extends RuntimeException {

    public EnvironmentNotFoundException(UUID id) {
        super("Environment not found: " + id);
    }
}