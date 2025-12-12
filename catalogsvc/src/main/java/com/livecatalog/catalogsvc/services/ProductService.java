package com.livecatalog.catalogsvc.services;

import org.springframework.stereotype.Service;

import com.livecatalog.catalogsvc.entities.Product;
import com.livecatalog.catalogsvc.events.ProductEvent;
import com.livecatalog.catalogsvc.repos.ProductRepository;

@Service
public class ProductService {
    
    ProductRepository productRepo;
    ProductEventProducer productEventProducer;

    public ProductService(ProductRepository repository, ProductEventProducer productEventProducer) {
        this.productRepo = repository;
        this.productEventProducer = productEventProducer;
    }

    public Product create(String name, String description, String category, Float price) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setCategory(category);
        product.setPrice(price);

        Product savedProduct = this.productRepo.save(product);

        ProductEvent event = new ProductEvent(savedProduct.getId(),
            savedProduct.getName(),
            savedProduct.getCategory(),
            savedProduct.getDescription(),
            savedProduct.getPrice(), "CREATED");
        this.productEventProducer.sendEvent(event);
        return savedProduct;
    }

    public Product get(String id) {
        return this.productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
