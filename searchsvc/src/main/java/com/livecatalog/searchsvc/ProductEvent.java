package com.livecatalog.searchsvc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductEvent {
    private String id;
    private String name;
    private String category;
    private String description;
    private float price;
    private String type;
}
