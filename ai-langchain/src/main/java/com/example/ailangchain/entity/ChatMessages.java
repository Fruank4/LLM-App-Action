package com.example.ailangchain.entity;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("chat_messages")
public class ChatMessages {
    //唯一标识，映射到 MongoDB 文档的 _id 字段 @Id
    private ObjectId id;
    private int messageId;
    private String content; //存储当前聊天记录列表的json字符串
}
