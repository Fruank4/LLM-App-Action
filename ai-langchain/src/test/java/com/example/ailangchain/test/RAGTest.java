package com.example.ailangchain.test;

import dev.langchain4j.community.model.dashscope.QwenTokenizer;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentByParagraphSplitter;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.onnx.HuggingFaceTokenizer;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */
@SpringBootTest
public class RAGTest {
    @Test
    public void testReadDocument() {
        //使用FileSystemDocumentLoader读取指定目录下的知识库文档 体育心理学
        Document document = FileSystemDocumentLoader
                .loadDocument("src/main/resources/sport_motion.txt",
                        new TextDocumentParser());
        System.out.println(document.text());
    }

    /**
     * 解析PDF
     */
    @Test
    public void testReadPDF() {
        Document document = FileSystemDocumentLoader.loadDocument(
                "src/main/resources/Kubernetes指南.pdf",
                new ApachePdfBoxDocumentParser()
        );
        System.out.println(document);
    }

    /**
     * 文档的分割-内存存储（mac系统无法运行通过——————默认的hugging face需要用GPU）
     */
    @Test
    public void testSplitDocumentAndStore() {
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();

        //1、使用FileSystemDocumentLoader读取指定目录下的知识库文档 //并使用默认的文档解析器对文档进行解析(TextDocumentParser)
        Document document = FileSystemDocumentLoader.loadDocument("src/main/resources/sport_teacher.txt");
        //2、分割文档:默认使用递归分割器，将文档分割为多个文本片段，每个片段包含不超过 300个token，并且有30个token的重叠部分保证连贯性
//        DocumentByParagraphSplitter documentSplitter = new DocumentByParagraphSplitter(
//                300,
//                30,
//                //token分词器:按token计算
//                new HuggingFaceTokenizer());

        //3、文本向量化:使用一个LangChain4j内置的轻量化向量模型对每个文本片段进行向量化
        //4、将原始文本和向量存储到向量数据库中(InMemoryEmbeddingStore)
        EmbeddingStoreIngestor.ingest(document, embeddingStore);

        System.out.println(embeddingStore);
    }

    @Test
    public void testTokenCount() {
        String text = "test 测试 token 长度的计算。";
        UserMessage userMessage = UserMessage.userMessage(text);
        //计算 token 长度
        // HuggingFaceTokenizer tokenizer = new HuggingFaceTokenizer();
        QwenTokenizer tokenizer = new QwenTokenizer(System.getenv("DASH_SCOPE_API_KEY"), "qwen-max");

        int count = tokenizer.estimateTokenCountInMessage(userMessage);
        System.out.println("token长度:" + count);
    }


}
