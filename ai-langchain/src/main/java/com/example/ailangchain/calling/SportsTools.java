package com.example.ailangchain.calling;

import com.example.ailangchain.SportType;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */
@Component
public class SportsTools {

    @Tool(name = "体育新闻", value = "获取体育新闻")
    String news(@ToolMemoryId int memoryId, @P(value="国家", required = true) String country, @P(value="体育类型", required = true) SportType type) {
        switch (type) {
            case BASKETBALL -> {
                return country + "国家队在世界杯中以78:65击败巴西队";
            }
            case SWIMMING -> {
                return country + "运动员打破了20年的记录";
            }
            case FOOTBALL -> {
                return "留给" + country + "队的时间不多了";
            }
            default -> {
                return "今天没有新闻";
            }
        }

    }
    @Tool(name = "预约场地", value = "预约运动场馆")
    double booking(@ToolMemoryId int memoryId, double x) {
        System.out.println("调用平方根运算 " + memoryId);
        return Math.sqrt(x);
    }
}
