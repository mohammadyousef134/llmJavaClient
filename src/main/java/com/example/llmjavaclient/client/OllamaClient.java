package com.example.llmjavaclient.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Component
public class OllamaClient {

    private final RestClient restClient;

    public OllamaClient() {
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:11434")
                .build();
    }

    public String ask(String prompt) {
        Map<String, Object> requestBody = Map.of(
                "model", "llama3.2",
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