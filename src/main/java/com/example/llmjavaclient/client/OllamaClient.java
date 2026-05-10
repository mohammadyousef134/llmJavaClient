package com.example.llmjavaclient.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Component
public class OllamaClient {

    private final RestClient restClient;
    @Value("${ollama.base-url}")
    private String ollamaUrl;
    @Value("${ollama.model}")
    private String ollamaModel;
    public OllamaClient() {
        this.restClient = RestClient.builder()
                .baseUrl(ollamaUrl)
                .build();
    }

    public String ask(String prompt) {
        Map<String, Object> requestBody = Map.of(
                "model", ollamaModel,
                "prompt", prompt,
                "stream", false
        );

        Map response = restClient.post()
                .uri("/api/generate")
                .body(requestBody)
                .retrieve()
                .body(Map.class);

        return response.get("response").toString();
    }
}