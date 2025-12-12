package com.livecatalog.catalogsvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livecatalog.catalogsvc.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>  {
    
}