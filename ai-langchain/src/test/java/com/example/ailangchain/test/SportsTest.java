package com.example.ailangchain.test;

import com.example.ailangchain.service.agent.MySportAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@SpringBootTest
public class SportsTest {


    @Autowired
    private MySportAssistant mySportAssistant;


    @Test
    public void testSports() {
        String r1 = mySportAssistant.chat(5, "你好，请问哪个国家足球最厉害？篮球呢？");
        System.out.println(r1);
        String r2 = mySportAssistant.chat(5, "是什么原因导致的？");
        System.out.println(r2);
        String r3 = mySportAssistant.chat(5, "你对中国足球有什么建议吗？");
        System.out.println(r3);
    }
}
