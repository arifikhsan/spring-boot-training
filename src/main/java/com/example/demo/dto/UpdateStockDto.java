package com.example.demo.dto;

public class UpdateStockDto {
    private Long id;
    private Long numberOfStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberOfStock() {
        return numberOfStock;
    }

    public void setNumberOfStock(Long numberOfStock) {
        this.numberOfStock = numberOfStock;
    }
}
