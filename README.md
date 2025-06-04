### 背景介绍
🤖️本项目是基于Java语言开发的一款服务端应用

作者对当下正流行的AI相关技术（AI Agent、Function Calling、RAG、向量数据库）进行整合，

旨在创建一个体育+运动康复行业智能聊天助手，实现具有持久化记忆的对话、调用业务系统功能、搭建私有知识库等功能。

- 框架：Langchain4j、SpringBoot

- 存储：Mysql、MongDB、Pinecone

- 模型：DeepSeek、Ollama、chatGpt-4o、Qwen-embedding-text、Huggingface、

整体结构如下，详情可以参考**[README.pdf](https://github.com/Fruank4/LLM-App-Action/blob/main/README.pdf)**
<img width="900" alt="image" src="https://github.com/user-attachments/assets/217df64c-781b-421a-a684-8c0c7df54413" />

===============================================================================================

### 一些Tips

1.如果想在你的本地运行起来，需要添加一些API_KEY到环境变量中

```sh
export DEEP_SEEK_API_KEY=${你的deepseek_api_key}
export DASH_SCOPE_API_KEY=${你的阿里百炼_api_key}
export PINECONE_API_KEY=${你的pinecone_api_key}
```
2.除了pinecone是云上的，其余的存储都建议放在Docker里（避免本机各种不兼容）
<img width="900" alt="image" src="https://github.com/user-attachments/assets/ab2bbb6f-9623-4c1c-9ae6-6672dd4549a8" />

3.使用的一些官方网站：

- Docker：https://docs.docker.com/desktop/setup/install/mac-install/
- langchain：https://docs.langchain4j.dev/
- ds：https://chat.deepseek.com/
- pinecone：https://www.pinecone.io/
- bailian：https://bailian.console.aliyun.com/

如有其他问题，欢迎交流～
🛰️：kok657576638




