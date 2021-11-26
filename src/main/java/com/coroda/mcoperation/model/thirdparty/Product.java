package com.coroda.mcoperation.model.thirdparty;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Product {

    private Long id;
    private String category;
    private String subCategory;
    private String model;
    private String brand;
    private String description;
    private String origin;
    private String material;
    private String dimensions;
    private String color;
    private BigDecimal priceUnit;
    private String image;
}
