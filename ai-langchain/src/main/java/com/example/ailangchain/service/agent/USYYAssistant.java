package com.example.ailangchain.service.agent;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",// 还是用Qwen吧，这个免费[捂脸哭]
        chatMemoryProvider = "chatMemoryProvider",// 永久记忆
        tools = "appointmentTools", // 预约工具
        contentRetriever = "contentRetriever" // rag
)


public interface USYYAssistant {
    @SystemMessage(fromResource = "usyy-prompt-template.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
