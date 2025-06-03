package com.example.ailangchain.calling;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@Component
public class CalculatorTools {

    @Tool(name = "加法", value = "返回两个参数相加之和")
    double sum(@ToolMemoryId int memoryId, @P(value="加数1", required = true) double a, @P(value="加数2", required = true) double b) {
        // 可以根据memoryId，进行特殊的逻辑处理
        if (memoryId % 2 == 0) {
            System.out.println("偶数调用加法运算 " + memoryId);
        }
        System.out.println("奇数调用加法运算 " + memoryId);
        return a + b;
    }
    @Tool(name = "平方根", value = "返回给定参数的平方根")
    double squareRoot(@ToolMemoryId int memoryId, double x) {
        System.out.println("调用平方根运算 " + memoryId);
        return Math.sqrt(x);
    }
}
