package com.example.ailangchain.service.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import java.util.ArrayList;
import java.util.Arrays;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "calculatorTools"
)
public interface ToolsChatAssistant {


    /**
     * 代理函数
     * @param memoryId
     * @param userMessage
     * @return
     */
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

}
