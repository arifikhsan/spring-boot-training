package com.example.demo.dto;

import com.example.demo.entity.ProductEntity;

public class ProductResponseDto {
    private String name;
    private Long quantity;
    private Long price;
    private String description;

    public ProductResponseDto(ProductEntity productEntity) {
        this.name = productEntity.getName();
        this.quantity = productEntity.getQuantity();
        this.price = productEntity.getPrice();
        this.description = "enaque";
    }

    public ProductResponseDto() {
    }

    public ProductResponseDto(String name, Long quantity, Long price, String description) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
