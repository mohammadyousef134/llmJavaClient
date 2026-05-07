package com.example.llmjavaclient.controller;

import com.example.llmjavaclient.dto.AskRequest;
import com.example.llmjavaclient.dto.AskResponse;
import com.example.llmjavaclient.service.LLmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LLmController {

    @Autowired
    private LLmService llmService;


    @PostMapping("/ask")
    public AskResponse ask(@RequestBody AskRequest request) {
        String answer = llmService.ask(request.getPrompt());
        return new AskResponse(answer);
    }
}