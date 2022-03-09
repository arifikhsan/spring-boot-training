package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.UpdateStockDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductEntity> all() {
        return (List<ProductEntity>) repository.findAll();
    }

    public List<ProductEntity> allInStock() {
        return repository.findByQuantityGreaterThan(0L);
    }

    public List<ProductEntity> fetch(Boolean isInStock) {
        return isInStock ? allInStock() : all();
    }

    public ProductEntity one(Long id) throws Exception {
        var productOption = repository.findById(id);
        if (productOption.isEmpty()) throw new Exception("Tidak nemu gan");
        return productOption.get();
    }

    public ProductEntity create(ProductDto productDto) {
        var product = new ProductEntity();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        return repository.save(product);
    }

    @Transactional
    public ProductEntity update(Long id, ProductDto productDto) throws Exception {
        var savedProduct = one(id);
        if (productDto.getName() != null && !productDto.getName().isEmpty())
            savedProduct.setName(productDto.getName());
        if (productDto.getPrice() != null) savedProduct.setPrice(productDto.getPrice());
        if (productDto.getQuantity() != null) savedProduct.setQuantity(productDto.getQuantity());
        return savedProduct;
    }

    @Transactional
    public ProductEntity updateStock(UpdateStockDto updateStockDto) throws Exception {
        var product = one(updateStockDto.getId());
        product.setQuantity(product.getQuantity() + updateStockDto.getNumberOfStock());
        return product;
    }

    public void destroy(Long id) {
        repository.deleteById(id);
    }
}
