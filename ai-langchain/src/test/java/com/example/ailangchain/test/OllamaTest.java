package com.example.ailangchain.test;

import dev.langchain4j.model.ollama.OllamaChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@SpringBootTest
public class OllamaTest {

    @Autowired
    private OllamaChatModel ollamaChatModel;
    @Test
    public void testOllama() {
        String answer = ollamaChatModel.chat("你和openai谁厉害？"); //输出结果
        System.out.println(answer);
    }
}
