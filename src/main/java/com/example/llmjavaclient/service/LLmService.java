package com.example.llmjavaclient.service;

import com.example.llmjavaclient.client.OllamaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LLmService {
    @Autowired
    private OllamaClient ollamaClient;

    public String ask(String prompt) {
        if (prompt == null) {
            throw new IllegalArgumentException("Prompt cannot be empty");
        }

        return ollamaClient.ask(prompt);
    }
}
