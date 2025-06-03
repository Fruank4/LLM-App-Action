package com.example.ailangchain.bean;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@Configuration
public class Config2 {

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
//                .minScore(0.8)
                .build();
    }
}
