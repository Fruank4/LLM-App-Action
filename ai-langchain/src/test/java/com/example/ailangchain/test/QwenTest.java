package com.example.ailangchain.test;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@SpringBootTest
public class QwenTest {

    @Autowired
    private QwenChatModel qwenChatModel;

    /**
     * 通义千问大模型
     */
    @Test
    public void testDashScopeQwen() {
        //向模型提问
        String answer = qwenChatModel.chat("你好，你是千问吗");
        //输出结果
        System.out.println(answer);
    }
}
