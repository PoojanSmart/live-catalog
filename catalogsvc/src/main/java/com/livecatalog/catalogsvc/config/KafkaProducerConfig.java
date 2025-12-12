package com.livecatalog.catalogsvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.livecatalog.catalogsvc.events.ProductEvent;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public KafkaTemplate<String, ProductEvent> kafkaTemplate(ProducerFactory<String, ProductEvent> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
