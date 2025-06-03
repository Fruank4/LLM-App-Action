package com.example.ailangchain.service.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider"
)
public interface PromptsChatAssistant {

    /**
     * 带有系统提示词的服务
     * @param memoryId 聊天id
     * @param userMessage 用户消息 * @return
     */
    @SystemMessage(value = "你是一个东北人，请用小沈阳儿的语气来回答我的问题，你今年{{age}}岁")
    String chat(@MemoryId int memoryId, @V ("age") int age, @UserMessage String userMessage);



    @UserMessage(value = "你是周杰伦，请你根据我的{{emotion}}，以及{{scene}}给我推荐一些你的歌曲，并且加一些emoji表情")
    String chat(@MemoryId int memoryId, @V("emotion") String emotion, @V("scene")String scene );
}
