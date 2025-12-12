package com.livecatalog.searchsvc.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.livecatalog.searchsvc.ProductEvent;

@Service
public class ProductEventListener {
    public final ElasticSearchIndexer indexer;
    
    public ProductEventListener(ElasticSearchIndexer indexer) {
        this.indexer = indexer;
    }

    @KafkaListener(topics = "product-events", groupId = "search-service")
    public void consume(ProductEvent event) {
        System.out.println("Received event: " + event.getId() + " type=" + event.getType());
        switch (event.getType()) {
            case "CREATED":
            case "UPDATED":
                indexer.index(event);
            default:
                break;
        }
    }
}
