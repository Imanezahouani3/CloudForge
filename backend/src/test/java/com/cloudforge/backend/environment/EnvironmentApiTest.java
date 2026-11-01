package com.cloudforge.backend.environment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class EnvironmentApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EnvironmentService environmentService;

    @Test
    void createsEnvironmentWithValidUrl() throws Exception {
        mockMvc.perform(post("/api/environments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"repositoryUrl\":\"https://github.com/Imanezahouani3/CloudForge\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("PENDING"));
    }

    @Test
    void rejectsInvalidUrlWithBadRequest() throws Exception {
        mockMvc.perform(post("/api/environments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"repositoryUrl\":\"nimporte quoi\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void returnsExistingEnvironmentById() throws Exception {
        EnvironmentRequest created = environmentService.create(
                new CreateEnvironmentRequest("https://github.com/Imanezahouani3/CloudForge"));

        mockMvc.perform(get("/api/environments/" + created.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.repositoryUrl").value("https://github.com/Imanezahouani3/CloudForge"));
    }

    @Test
    void returnsNotFoundForUnknownId() throws Exception {
        mockMvc.perform(get("/api/environments/00000000-0000-0000-0000-000000000000"))
                .andExpect(status().isNotFound());
    }
}