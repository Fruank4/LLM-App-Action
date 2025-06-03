package com.example.ailangchain.test;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@SpringBootTest
public class LLMTest {

//    @Test
//    public void testGPTDemo() {
//        //初始化模型
//        OpenAiChatModel model = OpenAiChatModel.builder()
//                // langchain官方给的，用于测试演示的url和key
//                .baseUrl("http://langchain4j.dev/demo/openai/v1")
//                .apiKey("demo")
//                .modelName("gpt-4o-mini") //设置模型名称
//                .build();
//        String result = model.chat("你好，我是李闯～");
//        System.out.println(result);
//    }


    /**
     * 集成了springboot，自动创建model bean
     */
    @Autowired
    private OpenAiChatModel openAiChatModel;
    @Test
    public void testDeepSeek() {
        String answer = openAiChatModel.chat("你好,你是谁"); //输出结果
        System.out.println(answer);
    }
}
