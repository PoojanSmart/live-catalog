package com.livecatalog.catalogsvc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livecatalog.catalogsvc.dto.ProductDTO;
import com.livecatalog.catalogsvc.entities.Product;
import com.livecatalog.catalogsvc.services.ProductService;

@RestController
@RequestMapping("/api/catalogs")
public class ProductController {
    
    ProductService productService;

    public ProductController(ProductService service) {
        this.productService = service;
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productdto) {
        Product p = this.productService.create(productdto.getName(), productdto.getDescription(), productdto.getCategory(), productdto.getPrice());
        return new ProductDTO(p.getId(), p.getName(), p.getDescription(), p.getCategory(), p.getPrice());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        try {
            Product p = this.productService.get(id);
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 }
