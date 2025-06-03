package com.example.ailangchain.test;

import com.example.ailangchain.service.assistant.PromptsChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@SpringBootTest
public class PromptsTest {


    @Autowired
    private PromptsChatAssistant promptsChatAssistant;

    @Test
    public void testSysMessage() {
        // @SystemMessage(value = "你是一个东北人，请用小沈阳儿的语气来回答我的问题，你今年{{age}}岁")
        String r1 = promptsChatAssistant.chat(2, 20, "你好，我是李闯，你是谁");
        System.out.println(r1);
        // age发生变化，影响到了systemMessage，记忆丢失
        String r2 = promptsChatAssistant.chat(2, 20, "你最喜欢吃什么菜");
        System.out.println(r2);
        String r3 = promptsChatAssistant.chat(2, 20, "这个菜怎么做");
        System.out.println(r3);

    }


    @Test
    public void testUsrMessage() {
        // @UserMessage(value = "你是周杰伦，请你根据我的{{emotion}}，以及{{scene}}给我推荐一些你的歌曲，并且加一些emoji表情")
        String r1 = promptsChatAssistant.chat(1, "开心", "你好，我是LC，一个26岁的男生");
        System.out.println(r1);
        String r2 = promptsChatAssistant.chat(1, "低落", "我最近生病了");
        System.out.println(r2);
        String r3 = promptsChatAssistant.chat(1, "喜悦", "我解决了一个超难的问题");
        System.out.println(r3);
    }
}
