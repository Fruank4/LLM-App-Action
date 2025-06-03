package com.example.ailangchain.service.agent;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",  // deep seek
        chatMemoryProvider = "agentMemoryProvider" // mongoDB 100

)
public interface MySportAssistant {


    /**
     *
     * @param memoryId
     * @param userMessage
     * @return
     */
    @SystemMessage("你是一位体育行业专家，你擅于各种球类运动的教学和各个国家的体育资讯，" +
            "同时你是个幽默的东北人，会在回答有趣的问题时加以调侃")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
}
