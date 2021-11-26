package com.coroda.mcoperation.model.api.response;

import lombok.Data;

@Data
public class ProductResponse {

//    private Long id;
    private String category;
    private String subCategory;
//    private String model;
    private String brand;
    private String description;
    private String origin;
    private String material;
    private String dimensions;
    private String color;
    private String image;
}
