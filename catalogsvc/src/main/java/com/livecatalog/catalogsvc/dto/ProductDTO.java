package com.livecatalog.catalogsvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private String category;
    private Float price;
}
