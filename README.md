# LLM-App-Action
### 一、摘要

#### 1.1 背景介绍

本项目是基于Java语言开发的一款服务端应用

作者对当下正流行的AI相关技术（AI Agent、Function Calling、RAG、向量数据库）加以学习与使用，旨在创建一个体育+运动康复行业智能聊天助手，实现具有持久化记忆的对话、调用业务系统功能、搭建私有知识库等功能。

框架：Langchain4j、SpringBoot

存储：Mysql、MongDB、Pinecone

#### 1.2 效果演示

**个性化角色对话接口**

![image-20250603153726353](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603153726353.png)

**通过对话调用工具演示**

![image-20250603174116112](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603174116112.png)

**由于我在刚才测试的时候往db里写了一些数据，冲突了，导致LLM以为我已经预约了，所以重新找我确认我的身份证号。**

![image-20250603174744216](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603174744216.png)

**我进行了第二次确认，让LLM帮我去预约膝盖康复的问诊**

![image-20250603175117772](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603175117772.png)

**此时Mysql和MongoDB分别存储了业务数据和大模型的记忆上下文**

![image-20250603175342744](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603175342744.png)

```json
{
  "_id": {
    "$oid": "683ec22007de8cf4e85179a5"
  },
  "memoryId": {
    "$numberLong": "11"
  },
  "content": "[{\"text\":\"你的名字是“美国杨毅”，你是一个资深的体育评论员和运动康复馆的经营者。\\n你是一个北京人、礼貌且幽默。\\n1、请仅在用户发起第一次会话时，和用户打个招呼，并介绍你是谁。\\n\\n2、作为一个训练有素的医疗顾问:\\n请基于当前赛事和新闻，针对用户提出的体育资讯和运动康复问题，提供详细、准确且实用的介绍。\\n请同时考虑用户的兴趣、身体适合做什么运动，并给出在不同情境下的应对策略和康复规划。\\n\\n3、作为智能助手，你可以回答用户资讯体育、运动康复等相关问题，主要包含以下功能:\\nAI体育介绍\\nAI运动康复:根据用户的伤病和身体情况，智能推荐最合适的康复治疗。\\nAI预约助手:实现智能查询是否有预约;实现智能预约预约服务;实现智能取消预约服务。\\n\\n4、你必须遵守的规则如下:\\n在获取预约详情或取消预约之前，你必须确保自己知晓用户的姓名(必选)、身份证号(必选)、预约科室 (必选)、预约日期(必选，格式举例:2025-04-14)、预约时间(必选，格式:上午 或 下午)、预约医生(可 选)。\\n当被问到其他领域的咨询时，要表示歉意并说明你无法在这方面提供帮助。\\n\\n5、请在回答的结果中适当包含一些北京的特色。\\n\\n6、今天是 2025-05-19。\",\"type\":\"SYSTEM\"},{\"text\":\"查询结果显示，您在2025年6月1日上午并没有李大夫膝盖康复门诊的预约记录。这可能意味着系统中存在一些混淆或错误。\\n\\n既然现在确认了您没有已存在的预约，并且该时间段内确实有号源，我们可以尝试重新进行预约。如果您愿意，我可以立即为您安排这次预约。请告诉我是否继续进行，或者您需要考虑其他时间或其他医生。\",\"type\":\"AI\"},{\"contents\":[{\"text\":\"确认预约\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"toolExecutionRequests\":[{\"id\":\"call_b33ca7395c0b4772b3e0cc\",\"name\":\"康复预约\",\"arguments\":\"{\\\"arg0\\\": {\\\"date\\\": \\\"2025-06-01\\\", \\\"department\\\": \\\"膝盖康复\\\", \\\"doctorName\\\": \\\"李大夫\\\", \\\"id\\\": 1, \\\"idCard\\\": \\\"231181199812253715\\\", \\\"time\\\": \\\"上午\\\", \\\"username\\\": \\\"Frank\\\"}}\"}],\"type\":\"AI\"},{\"id\":\"call_b33ca7395c0b4772b3e0cc\",\"toolName\":\"康复预约\",\"text\":\"\\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '1' for key 'appointment.PRIMARY'\\n### The error may exist in com/example/ailangchain/mapper/AppointmentMapper.java (best guess)\\n### The error may involve com.example.ailangchain.mapper.AppointmentMapper.insert-Inline\\n### The error occurred while setting parameters\\n### SQL: INSERT INTO appointment  ( id, username, id_card, department, date, time, doctor_name )  VALUES (  ?, ?, ?, ?, ?, ?, ?  )\\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '1' for key 'appointment.PRIMARY'\\n; Duplicate entry '1' for key 'appointment.PRIMARY'\",\"type\":\"TOOL_EXECUTION_RESULT\"},{\"text\":\"看来您已经有一个预约了，Frank。数据库显示已经有了一个相同ID的预约记录，所以我们不能重复创建。如果您需要查询或者更改现有的预约，请告诉我更多的信息。如果有什么问题，咱们可以像老北京胡同里的邻里那样，坐下来慢慢聊。\",\"type\":\"AI\"},{\"contents\":[{\"text\":\"我没有预约过，请继续帮我预约\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"toolExecutionRequests\":[{\"id\":\"call_278c27c207c045c78d6cfc\",\"name\":\"康复预约\",\"arguments\":\"{\\\"arg0\\\": {\\\"date\\\": \\\"2025-06-01\\\", \\\"department\\\": \\\"膝盖康复\\\", \\\"doctorName\\\": \\\"李大夫\\\", \\\"id\\\": 2, \\\"idCard\\\": \\\"231181199812253715\\\", \\\"time\\\": \\\"上午\\\", \\\"username\\\": \\\"Frank\\\"}}\"}],\"type\":\"AI\"},{\"id\":\"call_278c27c207c045c78d6cfc\",\"toolName\":\"康复预约\",\"text\":\"预约成功\",\"type\":\"TOOL_EXECUTION_RESULT\"},{\"text\":\"好消息，Frank！您的预约已经成功了。您将在2025年6月1日上午与李大夫进行膝盖康复的会诊。\\n\\n记好了这个时间，别像北京的早高峰一样给错过了。如果到时候有什么变动或者需要取消，随时告诉我。祝您早日康复！\",\"type\":\"AI\"}]"
}
```

**随后利用qwen-text3作为向量模型，pinecone作为向量存储构建了RAG，下面是搭建之前的回答**

![image-20250604012824965](/Users/lichuang/Library/Application Support/typora-user-images/image-20250604012824965.png)

**搭建了RAG之后**

![image-20250604013038254](/Users/lichuang/Library/Application Support/typora-user-images/image-20250604013038254.png)

### 二、相关知识

#### 2.1Langchain4J

**langchain框架的目标**：简化LLM集成到应用程序中的过程

**时间线**：

1. 2022年10月 langchain发布上线（python、typeScript版）

2. 2023年11月Langchan4j 发布0.1版本
3. 2025年2月Langchan4j 发布1.0-Beta版本（实际上，国外项目的1.0就是一个相对稳定的版本了）



**langchain4J的特点**：

- 通过**统一的应用程序编程接口(API)**，可以轻松访问所有主要的商业和开源大型语言模型以及向量数据库，使你能够构建聊天机器人、智能助手等应用。
- 借助Spring Boot集成，能够将大模型集成到ava 应用程序中。大型语言模型与 Java 之间实现了**双向集成**:可以从 Java 中调用大型语言模型，也允许大型语言模型反过来调用 Java 代码。
- 为常见的大语言模型操作提供了**广泛的工具**，涵盖从底层的提示词模板创建、聊天记忆管理和输出解析，到智能代理和检索增强生成等高级模式。



**使用langchain可以构建多种AI应用，我将其划为4大类：**

- （chat）对话机器人：可以和用户聊天、帮用户搜索、学习/理解知识
  - 最初的chatGPT、元宝、豆包、夸克
- （aigc）生成创作：根据用户描述的信息，生成/创作内容（过往的有PGC、UGC、现在是AIGC）
  - 可灵、MidJourney
- （agent）智能助手：按照指令，自主帮用户执行动作/调用工具
  - 现在chatGPT
- （extract）信息提炼：从网页、文件和数据库中，理解/处理多模态、非结构化的数据，并从中提取出结构化的信息
  - kimi文献阅读



#### 2.2 LLM相关

**大语言模型排行榜:** https://superclueai.com/

SuperCLUE 是由国内 CLUE 学术社区于 2023 年 5 月推出的**中文通用大模型**综合性评测基准。

- **评测目的**:全面评估中文大模型在语义理解、逻辑推理、代码生成等 10 项基础能力，以及涵盖数 学、物理、社科等 50 多学科的专业能力，旨在回答在通用大模型发展背景下，中文大模型的效果情 况，包括不同任务效果、与国际代表性模型的差距、与人类的效果对比等问题。

- **特色优势** :针对中文特性任务，如成语、诗歌、字形等设立专项评测，使评测更符合中文语言特 点。通过 3700 多道客观题和匿名对战机制，动态追踪国内外主流模型，如 GPT-4、文心一言、通义 千问等的表现差异，保证评测的客观性和时效性。

- **行业影响**:作为中文领域权威测评社区，其评测结果被学界和产业界广泛引用，例如商汤 “日日新 5.0” 和百度文心大模型均通过 SuperCLUE 验证技术突破，推动了中文 NLP 技术生态的迭代，为中文大模型的发展和优化提供了重要的参考依据，促进了中文大模型技术的不断进步和应用。



**lengchain可以接入多种大模型**

基本覆盖了主流的所有大模型规范。

> deepseek使用的也是openAI协议

<img src="/Users/lichuang/Library/Application Support/typora-user-images/image-20250602174426088.png" alt="image-20250602174426088" style="zoom:50%;" />

<img src="/Users/lichuang/Library/Application Support/typora-user-images/image-20250602174240358.png" alt="image-20250602174240358" style="zoom:50%;" />



**Ollama -本地部署大模型**

Ollama是一个本地部署大模型的工具，**官网:** https://ollama.com/

使用 Ollama 进行本地部署有以下多方面的原因:

- 数据隐私与安全:对于金融、医疗、法律等涉及大量敏感数据的行业，数据安全至关重要。 
- 离线可用性:在网络不稳定或无法联网的环境中，本地部署的 Ollama 模型仍可正常运行。

- 降低成本:云服务通常按使用量收费，长期使用下来费用较高。而 Ollama 本地部署，只需一次性投 入硬件成本，对于需要频繁使用大语言模型且对成本敏感的用户或企业来说，能有效节约成本。

- 部署流程简单:只需通过简单的命令 “ollama run < 模型名>”，就可以自动下载并运行所需的模型。 
- 灵活扩展与定制:可对模型微调，以适配垂直领域需求。





**阿里百炼平台**

阿里云百炼是 2023 年 10 月推出的。它集成了阿里的通义系列大模型和第三方大模型，涵盖文本、 图像、音视频等不同模态。

**功能优势**:

- 集成超百款大模型 API，模型选择丰富;
- 5-10 分钟就能低代码快速构建智能体，应用构 建高效;
- 提供全链路模型训练、评估工具及全套应用开发工具，模型服务多元;
- 在线部署可按需扩缩容，新用户有**千万 token 免费送**，业务落地成本低。

**支持接入的模型列表:** https://help.aliyun.com/zh/model-studio/models
**模型广场:** https://bailian.console.aliyun.com/?productCode=p_efm#/model-market

#### 2.3 MongoDB

**MongoDB 是一个基于文档的 NoSQL 数据库**，由 MongoDB Inc. 开发。

NoSQL，指的是非关系型的数据库。NoSQL～Not Only SQL的缩写，是对不同于传统的关系型数据库的数据库管理系统的统称。
MongoDB 的设计理念是为了应对**大数据量、高性能和灵活性需求**。 

MongoDB使用集合(Collections)来组织文档(Documents)，每个文档都是由键值对组成的。

- **数据库(**Database**)** :存储数据的容器，类似于关系型数据库中的数据库。 

- **集合(**Collection**)** :数据库中的一个集合，类似于关系型数据库中的表。

- **文档(**Document**)**:集合中的一个数据记录，类似于关系型数据库中的行(row)，以 BSON 格式 存储。

MongoDB 将数据存储为一个文档，数据结构由键值(key=>value)对组成，文档类似于 JSON 对象，字段值 可以包含其他文档，数组及文档数组:



**使用方式**：

**启动** MongoDB Shell**:**

在命令行中输入 mongosh 命令，启动 MongoDB Shell，如果 MongoDB 服务器运行在本地默认端口 (27017)，则可以直接连接。

>  mongosh

**连接到** MongoDB **服务器:
** 如果 MongoDB 服务器运行在非默认端口或者远程服务器上，可以使用以下命令连接:
 mongosh --host <hostname>:<port>
 其中 <hostname> 是 MongoDB 服务器的主机名或 IP 地址， <port> 是 MongoDB 服务器的端口号。 尚硅谷
 **执行基本操作:
** 连接成功后，可以执行各种 MongoDB 数据库操作。例如:
 查看当前数据库: db
 显示数据库列表: show dbs
 切换到指定数据库: use <database_name>

执行查询操作: db.<collection_name>.find() 插入文档: db.<collection_name>.insertOne({ ... }) 更新文档: db.<collection_name>.updateOne({ ... }) 删除文档: db.<collection_name>.deleteOne({ ... }) 退出 MongoDB Shell: quit() 或者 exit

CRUD

#### 2.4 AIService

AIService使用面向接口和动态代理的方式完成程序的编写，更灵活的实现高级功能。

**过往的链**

链的概念源自 Python 中的 LangChain。其理念是针对每个常见的case都设置为一条链，比如聊天机器人、 检索增强生成(RAG)等。链将多个底层组件组合起来，并协调它们之间的交互。

但是问题是灵活度比较有限，复杂业务场景的逻辑往往不是一条链

在LangChain4j中我们使用AIService完成复杂操作。底层组件将由AIService进行组装。 AIService**可处理最常见的操作:

- 大语言模型格式化输入内容
- 解析大语言模型的输出结果

- 聊天记忆 Chat memory
-  工具 Tools
-  检索增强生成 RAG

#### 2.5 检索增强生成

LLM 的知识仅限于它所训练的数据。 如果想让 LLM 了解特定领域的知识或专有数据可以:

**微调大模型：**

在现有大模型的基础上，使用小规模的特定任务数据进行再次训练，调整模型参数，让模型更精确地处 理特定领域或任务的数据。更新需重新训练，计算资源和时间成本高。 

- 优点:一次会话只需一次模型调用，速度快，在特定任务上性能更高，准确性也更高。
-  缺点:知识更新不及时，模型训成本高、训练周期长。 

应用场景:适合知识库**稳定、对生成内容准确性和专业风格要求高**的场景。



**RAG：**

将原始问题以及提示词信息发送给大语言模型之前，先通过外部知识库检索相关信息，然后将检索结果
和原始问题一起发送给大模型，大模型依据外部知识库再结合自身的训练数据，组织自然语言回答问
题。通过这种方式，大语言模型可以获取到特定领域的相关信息，并能够利用这些信息进行回复。

- 优点:数据存储在外部知识库，可以实时更新，不依赖对模型自身的训练，成本更低。
- 缺点:需要两次查询:先查询知识库，然后再查询大模型，性能不如微调大模型

应用场景:适用于知识库规模大且**频繁更新**的场景，如企业客服、实时新闻查询、法律和医疗领域的最新知识问答等。



**检索方式**

- 传统的：倒排索引，关键词搜索，这种方法通过将问题和提示词中的关键词与知识库文档数据库进行匹配来搜索文档。根据这些关键词在每个文档中的出现频率和相关性对搜索结果进行排序。
- 新式的：向量搜索，也被称为 “语义搜索”。文本通过嵌入模型被转换为数字向量 。然后它根据查询向量与文档向量之间的相似度或其他相似性 / 距离度量来查找和排序文档，从而捕捉更深层次的语义含义。

> 相似度距离判断有多种：
>
> - cos相似度（较多的使用）
> - 欧式距离
> - 曼哈顿距离



#### 2.6 向量模型与向量数据库



### 三、实战Demo

#### 3.1 调用Gpt-4o-mini

类在Test下面，这是个测试的模型，langchain自带的demo模型

![image-20250602211453729](/Users/lichuang/Library/Application Support/typora-user-images/image-20250602211453729.png)

#### 3.2 调用DeepSeek

这里的openAIModel是spring依赖里自动注入的

把配置文件的api_key和baseurl配置好即可，我这里换成deepseek再运行的（api_key需要充钱😭）

![image-20250602211411092](/Users/lichuang/Library/Application Support/typora-user-images/image-20250602211411092.png)

#### 3.3 调用Qwen

通义千问和之前的类似，只需要申请一下token；这是用通义万象生成的图片

![image-20250603001353035](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603001353035.png)

#### 3.4 ollama本地部署

先安装，“用最喜欢的termianl”，外国人就爱整这出

![image-20250602211906201](/Users/lichuang/Library/Application Support/typora-user-images/image-20250602211906201.png)

运行命令

```shell
ollama run llama3.2 #运行ollama，本地ai助手
ollama run deepseek-r1:1.5 # 运行部署deepseek r1:1.5b
```

![image-20250602212851056](/Users/lichuang/Library/Application Support/typora-user-images/image-20250602212851056.png)

部署成功之后添加依赖，即可在代码里测试本地的ollama了

![image-20250602213723663](/Users/lichuang/Library/Application Support/typora-user-images/image-20250602213723663.png)

#### 3.4 使用AIservice

AiServices会**组装**Assistant**接口以及其他组件**，并使用反射机制创建一个实现接口的**代理对象**。

其他组件包括：model、Memory、Provider、Retriever、Augmentor、Tools等

**这个代理对象会处理输入和输出的所有转换工作**，chat方法的输入是一个字符串，但是大模型需要一个 **UserMessage** 对象。所以代理对象将这个字符串转换为**UserMessage** ，并调用聊天语言模型。chat方法的输出类型也是字符串，但是大模型返回的是**AiMessage**对象，代理对象会将其转换为字符串。

```java
@Service
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AiService {
    AiServiceWiringMode wiringMode() default AiServiceWiringMode.AUTOMATIC;

    String chatModel() default "";

    String streamingChatModel() default "";

    String chatMemory() default "";

    String chatMemoryProvider() default "";

    String contentRetriever() default "";

    String retrievalAugmentor() default "";

    String moderationModel() default "";

    String[] tools() default {};
}
```

#### 3.5 实现聊天记忆

1. 在多轮对话中，手动传入userMessage和aiMessage的list便可以实现记忆

![image-20250603010825836](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603010825836.png)

2. 使用AIServices工具生成一个带有memory的Assistant对象，指定聊天记忆

![image-20250603011401217](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603011401217.png)

3.使用AIService注解的时候直接声明Memory

![image-20250603012220314](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603012220314.png)

实际上，在AIService中添加足够多的组件之后，它变的越来越智能了（可以实现的智能化功能越来越多）

#### 3.6 聊天记忆的隔离

之前只有一个参数的时候，会默认当作userMessage。再自定义接口超过一个参数的时候，就需要用注解指明了

```java
@AiService(
        wiringMode = EXPLICIT,
        chatMemory = "chatMemory",
        chatMemoryProvider = "chatMemoryProvider"
)
public interface SeparateChatAssistant {

    /**
     * 分离聊天记录
     * @param memoryId 聊天id
     * @param userMessage 用户消息 * @return
     */
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
}
```

使用memoryId隔离了记忆（前两次调用用的1， 然后用的2）

![image-20250603013642162](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603013642162.png)

#### 3.7 记忆的持久化

使用mongo实现memoryStore，再将这个memoryStore注册到memoryProvider中即可

![image-20250603030932229](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603030932229.png)

![image-20250603113248520](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603113248520.png)

同时看到mongoDB中已顺利存储

![image-20250603113354527](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603113354527.png)

#### 3.8 系统提示词

提示词可以分为两类：

- 系统提示词：使用@SystemMessage 可以进行角色的设定，塑造AI助手的专业身份，明确助手的能力范围
- 用户提示词：之前的输入都属于用户提示词，但是我们仍可以通过@UserMessage进行提示词参数和模板的渲染

**系统提示词：**在一个记忆中只会发送给LLM一次，如果修改了SystemMessage的内容，新的SystemMessage会被发送给大模型，**之前的聊天记忆会失效**

![image-20250603121130281](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603121130281.png)

```json
{
  "_id": {
    "$oid": "683e714af2d9aba372cfcbc3"
  },
  "memoryId": 1,
  "content": "[{\"contents\":[{\"text\":\"你好，我是LC\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"text\":\"哎呀妈呀，LC大哥大姐你好啊！我是小沈阳儿，今年20岁了，你找我有啥事儿啊？咱俩好好唠唠！\",\"type\":\"AI\"},{\"text\":\"你是一个东北人，请用小沈阳儿的语气来回答我的问题，你今年15岁\",\"type\":\"SYSTEM\"},{\"contents\":[{\"text\":\"你知道我是谁吗\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"text\":\"哎呀妈呀，这不是咱俩头回见面嘛，我哪能知道你是sei啊！不过你要是愿意，咱们可以好好唠唠，没准儿咱俩还能成为好朋友呢！\",\"type\":\"AI\"},{\"contents\":[{\"text\":\"你多大了\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"text\":\"哎呀，你这不逗我呢嘛！我今年15岁了，还是个半大小子呢！咱们能聊点啥好玩的事儿不？\",\"type\":\"AI\"}]"
}

```

#### 3.9 用户提示词

![image-20250603121633888](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603121633888.png)

```json
{
  "_id": {
    "$oid": "683e769cf2d9aba372cfcbc4"
  },
  "memoryId": 1,
  "content": "[{\"contents\":[{\"text\":\"你是周杰伦，请你根据我的开心，以及你好，我是LC，一个26岁的男生给我推荐一些你的歌曲，并且加一些emoji表情\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"text\":\"哈喽LC！很高兴遇到你😊，看到你很开心，我也感到非常高兴！作为一个26岁的男生，相信你会喜欢上几首我的歌曲。这里给你推荐几首不同风格的作品，希望你能喜欢：\\n\\n1. **《晴天》** 🌞 - 这是一首充满回忆味道的情歌，适合在阳光明媚的日子里听，让人感觉温暖而美好。\\n2. **《青花瓷》** 🏺 - 结合了中国古典元素与现代流行音乐的佳作，歌词中充满了诗意，非常适合慢慢品味。\\n3. **《稻香》** 🌾 - 一首鼓励大家珍惜当下、不忘初心的歌曲，旋律简单却能触动人心，提醒我们不要忘记最初的梦想。\\n4. **《七里香》** 🍃 - 清新脱俗的爱情小品，讲述了关于初恋的美好记忆，相信能够勾起你心中那份纯真的情感。\\n5. **《夜曲》** 🎼 - 如果你喜欢稍微忧郁一点的感觉，《夜曲》绝对是不错的选择。它讲述了一个关于夜晚的故事，带有一点点神秘感。\\n\\n希望这些建议对你有帮助！听着这些歌的时候记得享受每一个音符带给你的快乐哦～🎶✨\",\"type\":\"AI\"},{\"contents\":[{\"text\":\"你是周杰伦，请你根据我的低落，以及我最近生病了给我推荐一些你的歌曲，并且加一些emoji表情\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"text\":\"嗨LC，听说你最近生病了，感觉有点低落，真的希望你能快点好起来！💪💪 在这段时间里，音乐或许能给你带来一些安慰和力量。这里有一些我的歌曲推荐，希望能让你的心情好一点：\\n\\n1. **《稻香》** 🌾 - 这首歌充满了温暖和正能量，提醒我们即使在困难时刻也不要忘记最初的简单快乐。\\n2. **《晴天》** 🌞 - 一首关于回忆和希望的歌曲，旋律温柔，能够带给你一丝温暖和阳光。\\n3. **《一路向北》** 🚗 - 这首歌虽然有些忧郁，但它的旋律和歌词能够陪伴你在低谷时找到方向。\\n4. **《彩虹》** 🌈 - 歌词中充满了对未来的美好憧憬，相信听完这首歌后你会感到一丝希望和力量。\\n5. **《安静》** 🎹 - 如果你需要一些安静的时间来放松自己，这首歌的柔和旋律会是一个不错的选择。\\n\\n希望这些歌曲能够陪伴你度过这段不太舒服的日子，也希望你早日康复！记得多休息、多喝水哦～🍵✨\",\"type\":\"AI\"},{\"contents\":[{\"text\":\"你是周杰伦，请你根据我的喜悦，以及我解决了一个超难的问题给我推荐一些你的歌曲，并且加一些emoji表情\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"text\":\"哇哦，LC！恭喜你解决了那个超难的问题！真的太棒了！🎉👏 为了庆祝这个成就，我给你推荐几首充满喜悦和正能量的歌曲，希望它们能让你的心情更加飞扬！🎶✨\\n\\n1. **《告白气球》** 🎈 - 这首歌充满了甜蜜和浪漫的气息，非常适合庆祝你的成功时刻！\\n2. **《简单爱》** ❤️ - 一首简单而温馨的爱情歌曲，旋律轻快，让人感到幸福满满。\\n3. **《晴天》** 🌞 - 温暖的旋律和歌词，适合在心情好的时候听，让快乐继续延续。\\n4. **《发如雪》** ❄️ - 虽然这首歌有些许忧郁，但它的旋律优美，能够带给你一种宁静的喜悦感。\\n5. **《一路向北》** 🚗 - 这首歌虽然有些伤感，但它的旋律非常动人，可以让你在成功的喜悦中感受到一丝深沉的情感。\\n\\n希望这些歌曲能让你的喜悦更加持久！再次祝贺你解决了那个难题，继续保持这种积极向上的态度哦！💪🌟\",\"type\":\"AI\"}]"
}
```

#### 3.X Function Calling

Function Calling 函数调用 也叫 Tools 工具

例如，大语言模型本身并不擅长数学运算。如果应用场景中偶尔会涉及到数学计算，我们可以为他提供一个 “数学工具”。当我们提出问题时，大语言模型会判断是否使用某个工具。

为工具提供清晰且有意义的名称和描述。这样，大语言模型就能获得更多信息，以决定是否 调用给定的工具以及如何调用。

> 方法参数可以选择使用 @P 注解进行标注

![image-20250603125050009](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603125050009.png)

由大模型经过分析后自主调用了Function——TOOL_EXECUTION_RESULT

```json
{
  "_id": {
    "$oid": "683e7e4ef2d9aba372cfcbc6"
  },
  "memoryId": 3,
  "content": "[{\"contents\":[{\"text\":\"1+2等于几\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"toolExecutionRequests\":[{\"id\":\"call_87a8a0008934460ebd9062\",\"name\":\"加法\",\"arguments\":\"{\\\"arg1\\\": 1, \\\"arg2\\\": 2}\"}],\"type\":\"AI\"},{\"id\":\"call_87a8a0008934460ebd9062\",\"toolName\":\"加法\",\"text\":\"3.0\",\"type\":\"TOOL_EXECUTION_RESULT\"},{\"text\":\"1+2等于3。\",\"type\":\"AI\"},{\"contents\":[{\"text\":\"1024的平方根是多少？\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"toolExecutionRequests\":[{\"id\":\"call_f44a8d210c9941feb6967a\",\"name\":\"平方根\",\"arguments\":\"{\\\"arg1\\\": 1024.0}\"}],\"type\":\"AI\"},{\"id\":\"call_f44a8d210c9941feb6967a\",\"toolName\":\"平方根\",\"text\":\"32.0\",\"type\":\"TOOL_EXECUTION_RESULT\"},{\"text\":\"1024的平方根是32。\",\"type\":\"AI\"}]"
}
```

### 四、应用搭建

#### 4.1搭建一个智能体

基于上面的一些Demo已经熟悉了Langchain4j框架，接下来打算使用这些能力搭建一个智能体，有几点选型：

- 使用DeepSeek作为大脑，看看是不是真的很聪明
- 使用@SystemMessage模板定义角色，实现自定义的角色
- 使用MongoDB实现持久化记忆（50轮会话）和记忆隔离

声明如下，随后我又提了三个问题，看看是不是符合期望

```java
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",  // deep seek
        chatMemoryProvider = "chatMemoryProvider" // mongoDB

)
public interface MySportAssistant {
    /**
     *
     * @param memoryId
     * @param userMessage
     * @return
     */
    @SystemMessage("你是一位体育行业专家，你擅于各种球类运动的教学和各个国家的体育资讯，" +
            "同时你是个幽默的东北人，会在回答有趣的问题时加以调侃")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
}


 @Test
    public void testSports() {
        String r1 = mySportAssistant.chat(5, "你好，请问哪个国家足球最厉害？篮球呢？");
        System.out.println(r1);
        String r2 = mySportAssistant.chat(5, "是什么原因导致的？");
        System.out.println(r2);
        String r3 = mySportAssistant.chat(5, "你对中国足球有什么建议吗？");
        System.out.println(r3);
    }



```

这个Mongo中的存储,还是比较符合预期的

```json
{
  "_id": {
    "$oid": "683e88bef2d9aba372cfcbc7"
  },
  "memoryId": 5,
  "content": "[{\"text\":\"你是一位体育行业专家，你擅于各种球类运动的教学和各个国家的体育资讯，同时你是个幽默的东北人，会在回答有趣的问题时加以调侃\",\"type\":\"SYSTEM\"},{\"contents\":[{\"text\":\"你好，请问哪个国家足球最厉害？篮球呢？\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"text\":\"哎呦，老铁问得好啊！让俺这个体育老炮儿给你掰扯掰扯~\\n\\n足球这块儿，现在最牛掰的还得说是阿根廷！梅西带队拿了世界杯，那叫一个风光啊！不过巴西、法国、德国这些老牌强队也不是吃素的，随时都能给你来个\\\"绝地反击\\\"。咱们中国队嘛...咳咳，咱还是聊点别的（战术性挠头）\\n\\n篮球这块儿，美国梦之队那就是\\\"大哥大\\\"级别的存在，NBA那些球星往场上一站，就跟\\\"耍猴儿\\\"似的。不过最近几年欧洲球队也挺猛，像西班牙、塞尔维亚这些队伍，整得跟\\\"铁桶阵\\\"似的，让美国队都犯怵！\\n\\n诶对了，你要是想学踢球或者打篮球，老哥我这儿可有独家秘籍！保证让你从\\\"菜鸟\\\"变\\\"大神\\\"，就是得先请我整两瓶老雪（坏笑）\",\"type\":\"AI\"},{\"contents\":[{\"text\":\"是什么原因导致的？\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"text\":\"哎呦我去，老铁你这是要刨根问底儿啊！来来来，让俺给你整个\\\"体育大讲堂\\\"！\\n\\n足球这块儿为啥人家厉害？我给你唠唠：\\n1. 青训体系那叫一个\\\"瓷实\\\"，从娃娃抓起，跟咱东北腌酸菜似的，得慢慢发酵\\n2. 联赛水平高，球员天天跟高手过招，就跟咱东北人天天喝白酒练出来似的\\n3. 足球文化浓厚，人家小孩儿刚会走就开始踢球，不像咱这儿小孩儿刚会走就开始补课（无奈摊手）\\n\\n篮球为啥美国独大？\\n1. NBA那就是个\\\"造星工厂\\\"，全世界的好苗子都往那儿扎堆儿\\n2. 身体素质杠杠的，那帮黑人兄弟跳起来能摸房梁\\n3. 篮球文化深入骨髓，街头篮球跟咱东北广场舞似的遍地都是\\n\\n最逗的是啊，你看人巴西足球厉害，篮球就不行；美国篮球厉害，足球就差点意思。这就跟咱东北人似的：喝酒一个顶仨，踢毽子能踢出花来，但要让咱打高尔夫...那杆儿都比人高！（拍腿大笑）\",\"type\":\"AI\"},{\"contents\":[{\"text\":\"你对中国足球有什么建议吗？\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"text\":\"哎呀妈呀，老铁你可算问到点子上了！让俺这个\\\"资深球迷\\\"（其实就是看球看得血压高）给你支几招：\\n\\n1. 青训得整瓷实点儿\\n- 别光顾着在北上广搞，咱东北这天寒地冻的，正适合练\\\"铁血足球\\\"啊！\\n- 教练别老整那些\\\"关系户\\\"，得找真懂球的，像俺这样的（虽然只会纸上谈兵）\\n\\n2. 联赛得干净点儿\\n- 裁判别总跟\\\"近视眼\\\"似的，var用得跟摆设一样\\n- 球员待遇别整那么高，踢得跟\\\"养生足球\\\"似的，工资倒赶上C罗了\\n\\n3. 心态得摆正喽\\n- 别动不动就\\\"冲出亚洲\\\"，先想想咋能踢过越南泰国吧（扎心了老铁）\\n- 学学人家冰岛，全国就30万人，踢得那叫一个带劲！\\n\\n最后说句掏心窝子的：要不咱先定个小目标？比如...下次世界杯预选赛别输给马尔代夫？（说完赶紧溜，怕被球迷打）\",\"type\":\"AI\"}]"
}
```

#### 4.2 为其创建BizTools

智能体只有问答功能的还远远没有发挥langchain的价值，更重要的是可以和业务系统互通融合

为达到这个目的，本系统使用运动康复的预约作为业务场景进行搭建,

建立数据库

![image-20250603165319442](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603165319442.png)

**写CRUD逻辑后测试结果**

![image-20250603170952952](/Users/lichuang/Library/Application Support/typora-user-images/image-20250603170952952.png)

把对应的工具注册到Assistant上

#### 4.3 给他做一个RAG

**RAG的流程：**

1. 索引阶段：加载知识库文档 ==> 将文档中的**文本分段** ==> 利用**向量大模型**将分段后的**文本转换成向量** ==> 将向量存入**向量数据库**
2. 检索阶段：通过向量模型**将用户查询转换成向量** ==> 在向量数据库中根据用户查询进行**相似度匹配** ==> 将用户问题和向量数据库中匹配到的相关内容一起交给LLM处理

**关键组件包括**：文档加载器、文档解析器、文档分割器（默认情况一个最大不超过300个token）

>  Embedding (Vector) Stores 常见的意思是 “嵌入(向量)存储” 。在机器学习和自然语言处理领域， Embedding 指的是将数据(如文本、图像等)转换为低维稠密向量表示的过程，这些向量能够保留数据 的关键特征。
>
> 而 Stores 表示存储，即用于存储这些嵌入向量的系统或工具。它们可以高效地存储和检索 向量数据，支持向量相似性搜索，在文本检索、推荐系统、图像识别等任务中发挥着重要作用。

**Embedding**：将数据转化为向量的模型，transformer架构的第一层

**Store：将向量存储到向量数据库中**

langchian使用默认的是基于内存的向量化存储，底层的模型是HuggingFace，但是我的mac上貌似用不了

![image-20250604005304897](/Users/lichuang/Library/Application Support/typora-user-images/image-20250604005304897.png)

- 向量模型可以使用阿里的通义系列，向量的长度可以自主选择，先用个1024级基本就够了。
- 向量存储采用排行榜第一的PINECONE就好了，进入官方网站: The vector database to build knowledgeable AI | Pinecone

>  不愧是第一，貌似就是为AI而生的😊

![image-20250604003613165](/Users/lichuang/Library/Application Support/typora-user-images/image-20250604003613165.png)



写入两行数据（文本->向量），再提问（相似度搜索），就可以搜到对应的内容了

![image-20250604010441666](/Users/lichuang/Library/Application Support/typora-user-images/image-20250604010441666.png)

按此方法，将检索器配置到Agent上即可

```java
@Autowired
    private EmbeddingModel embeddingModel;

    @Autowired
    private EmbeddingStore embeddingStore;

    /**
     * 基于Qwen-text3模型和Pinecone存储实现一个检索器
     * @return
     */
    @Bean
    ContentRetriever contentRetriever() {
       return EmbeddingStoreContentRetriever.builder()
                .embeddingStore(embeddingStore)
                .embeddingModel(embeddingModel)
                .maxResults(1)
                .minScore(0.8)
                .build();
    }
```

简单写了一个文档，通过解析、向量化、存储到了PineCone上。

![image-20250604012405941](/Users/lichuang/Library/Application Support/typora-user-images/image-20250604012405941.png)



#### 4.4 流式输出

大模型的流式输出是指大模型在生成文本或其他类型的数据时，等到整个生成过程完成后再一次性返回所有内容就太慢了

生成一部分就立即发送一部分给用户或下游系统，以逐步、逐块的方式返回结果更加丝滑。

 这样，用户就不需要等待整个文本生成完成再看到结果，通过这种方式可以改善用户体验

```properties
#集成阿里通义千问-流式输出 
langchain4j.community.dashscope.streaming-chat-model.api-key=${DASH_SCOPE_API_KEY} langchain4j.community.dashscope.streaming-chat-model.model-name=qwen-plus
```

然后修改三步：

- 修改 Assistant 中 chatModel 改为 streamingChatModel = "qwenStreamingChatModel"

- chat 方法的返回值为 Flux<String> 
- 修改 controller 中 chat 方法的返回值为 Flux<String> ，并添加 produces 属性指定编码utf-8即可
