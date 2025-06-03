package com.example.ailangchain.test;

import com.example.ailangchain.service.assistant.Assistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */



@SpringBootTest
public class AIServiceTest {
//    @Autowired
//    private QwenChatModel qwenChatModel;
//    @Test
//    public void testChat() { //创建AIService
//        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel); //调用service的接口
//        String answer = assistant.chat("Hello");
//        System.out.println(answer);
//    }


    /**
     * 在使用了@AiService注解之后，可以直接注入
     */
    @Autowired
    private Assistant assistant;

    @Test
    public void testChat1() {
        String answer = assistant.chat("Hello");
        System.out.println(answer);
    }
}