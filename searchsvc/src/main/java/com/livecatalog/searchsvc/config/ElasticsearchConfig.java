package com.livecatalog.searchsvc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;

@Configuration
public class ElasticsearchConfig {

    @Value("${es.host}")
    private String esHost;

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        ElasticsearchClient esClient = ElasticsearchClient.of(builder -> builder.host(esHost));
        return esClient;
    }
}
