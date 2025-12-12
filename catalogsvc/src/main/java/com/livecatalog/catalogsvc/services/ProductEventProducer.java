package com.livecatalog.catalogsvc.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.livecatalog.catalogsvc.events.ProductEvent;

@Service
public class ProductEventProducer {
    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    public ProductEventProducer(KafkaTemplate<String, ProductEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(ProductEvent event) {
        this.kafkaTemplate.send("product-events", event.getId(), event);
    }
}
