package com.example.ailangchain.test;

import com.example.ailangchain.service.assistant.ToolsChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@SpringBootTest
public class ToolsTest {


    @Autowired
    private ToolsChatAssistant toolsChatAssistant;


    @Test
    public void testCalculator() {
        // 注册了数学计算工具的assistant
        String r1 = toolsChatAssistant.chat(3, "1+2等于几");
        System.out.println(r1);
        String r2 = toolsChatAssistant.chat(3, "1024的平方根是多少？");
        System.out.println(r2);
    }
}
