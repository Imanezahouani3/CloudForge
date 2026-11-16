package com.cloudforge.backend.environment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

class CreateEnvironmentRequestTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void acceptsValidGithubUrl() {
        var request = new CreateEnvironmentRequest("https://github.com/Imanezahouani3/CloudForge");

        assertTrue(validator.validate(request).isEmpty());
    }

    @Test
    void rejectsRandomText() {
        var request = new CreateEnvironmentRequest("nimporte quoi");

        assertFalse(validator.validate(request).isEmpty());
    }

    @Test
    void rejectsBlankUrl() {
        var request = new CreateEnvironmentRequest("   ");

        assertFalse(validator.validate(request).isEmpty());
    }

    @Test
    void rejectsUrlFromAnotherSite() {
        var request = new CreateEnvironmentRequest("https://evil.com/owner/repository");

        assertFalse(validator.validate(request).isEmpty());
    }
}
