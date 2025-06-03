package com.example.ailangchain.test;

import com.example.ailangchain.service.assistant.Assistant;
import com.example.ailangchain.service.assistant.MemoryChatAssistant;
import com.example.ailangchain.service.assistant.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@SpringBootTest
public class MemoryTest {

    @Autowired
    private QwenChatModel qwenChatModel;
    @Test
    public void testChatMemory1() {
        //第一轮对话
        UserMessage userMessage1 = UserMessage.userMessage("我是lc");
        ChatResponse chatResponse1 = qwenChatModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage(); //输出大语言模型的回复
        System.out.println(aiMessage1.text());

        //第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("我是谁？");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage1,
                aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();

        //输出大语言模型的回复
        System.out.println(aiMessage2.text());
    }

    @Test
    public void testChatMemory2() {
        //创建chatMemory
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        //创建AIService
        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatMemory(chatMemory)
                .chatLanguageModel(qwenChatModel)
                .build();
        //调用service的接口
        String answer1 = assistant.chat("我是LC"); System.out.println(answer1);
        String answer2 = assistant.chat("我是谁"); System.out.println(answer2);
    }


    @Autowired
    private MemoryChatAssistant assistant;

    @Test
    public void testChatMemory3() {
        // 在注解上声明之后可以 直接调用service的接口
        String answer1 = assistant.chat("我是LC"); System.out.println(answer1);
        String answer2 = assistant.chat("我是谁"); System.out.println(answer2);
    }


    /**
     * mongoDB的持久化的记忆存储
     */
    @Autowired
    private SeparateChatAssistant sAssistant;

    @Test
    public void testChatMemory4() {
        // 在注解上声明之后可以 直接调用service的接口
        String answer1 = sAssistant.chat(1, "我是LC");
        System.out.println(answer1);
        String answer2 = sAssistant.chat(1, "我是谁");
        System.out.println(answer2);
        String answer3 = sAssistant.chat(2, "我是谁");
        System.out.println(answer3);
    }
}
