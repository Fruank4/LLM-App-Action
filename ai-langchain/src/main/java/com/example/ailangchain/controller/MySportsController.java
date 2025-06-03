package com.example.ailangchain.controller;

import com.example.ailangchain.entity.ChatForm;
import com.example.ailangchain.service.agent.USYYAssistant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */


@Tag(name = "美国杨毅")
@RestController
@RequestMapping("/us_yy")
public class MySportsController {

    @Autowired
    private USYYAssistant usyyAssistant;

    @Operation(summary = "对话")
    @PostMapping("/chat")
    public String chat(@RequestBody ChatForm chatForm) {
        return usyyAssistant.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }

}
