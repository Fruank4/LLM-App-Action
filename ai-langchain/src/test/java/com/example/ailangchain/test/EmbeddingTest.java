package com.example.ailangchain.test;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.store.embedding.*;
import org.bouncycastle.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */
@SpringBootTest
public class EmbeddingTest {
    @Autowired
    private EmbeddingModel embeddingModel;
    @Test
    public void testEmbeddingModel(){
        Response<Embedding> embed = embeddingModel
                .embed("你好");
        System.out.println("向量维度:" + embed.content().vector().length);
        System.out.println("向量输出:" + embed.toString());
    }

    @Autowired
    private EmbeddingStore<TextSegment> embeddingStore;

    /**
     * 将文本转换成向量，然后存储到pinecone中
     *
     * 参考:
     **/
    @Test
    public void testPineconeEmbeded() {
        //将文本转换成向量
        TextSegment segment1 = TextSegment.from("我喜欢篮球");
        Embedding embedding1 = embeddingModel.embed(segment1).content(); //存入向量数据库
        embeddingStore.add(embedding1, segment1);
        TextSegment segment2 = TextSegment.from("我是LC呀");
        Embedding embedding2 = embeddingModel.embed(segment2).content();
        embeddingStore.add(embedding2, segment2);
        // 提问，并将问题转成向量数据
        Embedding queryEmbedding = embeddingModel.embed("你最喜欢的运动是什么?").content();
        // 创建搜索请求对象
        EmbeddingSearchRequest searchRequest = EmbeddingSearchRequest.builder()
                .queryEmbedding(queryEmbedding)
                //.minScore(0.8)
                .maxResults(1) //匹配最相似的一条记录
                .build();
        // 相似度搜索
        EmbeddingSearchResult<TextSegment> searchResult = embeddingStore.search(searchRequest);
        EmbeddingMatch<TextSegment> embeddingMatch = searchResult.matches().get(0);
        System.out.println(embeddingMatch.score());
        //返回文本结果
        System.out.println(embeddingMatch.embedded().text());
    }


    /**
     * 把本地知识上传到pinecone（向量化）
     */
    @Test
    public void testUploadKnowledgeLibrary() {
        String s = "大力金刚腿是LC,无敌铁头功是成哥,轻功水上漂是GM,十二路弹腿是TT";
        String[] split = Strings.split(s, ',');

        for (String s1 : split) {
            TextSegment segment1 = TextSegment.from(s1);
            Embedding embedding1 = embeddingModel.embed(segment1).content(); //存入向量数据库
            embeddingStore.add(embedding1, segment1);
        }
        return;
    }
}
