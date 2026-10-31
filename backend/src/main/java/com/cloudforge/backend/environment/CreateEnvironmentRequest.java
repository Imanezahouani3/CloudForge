package com.cloudforge.backend.environment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateEnvironmentRequest(
        @NotBlank(message = "repositoryUrl is required")
        @Pattern(
                regexp = "^https://github\\.com/[A-Za-z0-9_.-]+/[A-Za-z0-9_.-]+$",
                message = "repositoryUrl must look like https://github.com/owner/repository")
        String repositoryUrl) {
}