package com.livecatalog.searchsvc.service;

import org.springframework.stereotype.Service;

import com.livecatalog.searchsvc.ProductEvent;

import co.elastic.clients.elasticsearch.ElasticsearchClient;

@Service
public class ElasticSearchIndexer {
    private final ElasticsearchClient esClient;

    public ElasticSearchIndexer(ElasticsearchClient esClient) {
        this.esClient = esClient;
    }

    public void index(ProductEvent event) {
        try {
            esClient.index(i -> i.index("products").id(event.getId()).document(event));
            System.out.println("Product indexed: " + event.getId());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
}
