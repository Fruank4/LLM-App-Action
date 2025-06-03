package com.example.ailangchain.entity;

import lombok.Data;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@Data
public class ChatForm {
    /**
     * 对话id
     */
    private Long memoryId;

    /**
     * 用户问题
     */
    private String message;
}
