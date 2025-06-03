package com.example.ailangchain.test;

import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@SpringBootTest
public class WanXTest {

    /**
     * 通义万象
     */
    @Test
    public void testDashScopeQwen() {

        WanxImageModel wanxImageModel = WanxImageModel.builder()
                .modelName("wanx2.1-t2i-plus")
                .apiKey(System.getenv("DASH_SCOPE_API_KEY"))
                .build();

        Response<Image> response = wanxImageModel.generate("一个青年在深夜调试大模型");
        //输出结果
        System.out.println(response.content().url());
    }

}
