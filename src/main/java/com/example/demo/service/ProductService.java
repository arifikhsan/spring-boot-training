package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.transaction.Transactional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Iterable<ProductEntity> all() {
        return repository.findAll();
    }

    public ProductEntity one(Long id) {
        var productOption = repository.findById(id);
        if (productOption.isEmpty()) throw new NotFoundException("Tidak nemu gan");
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
    public ProductEntity update(Long id, ProductDto productDto) {
        var productOption = repository.findById(id);
        if (productOption.isEmpty()) throw new NotFoundException("Tidak nemu gan");
        var savedProduct = productOption.get();
        if (productDto.getName() != null && !productDto.getName().isEmpty())
            savedProduct.setName(productDto.getName());
        if (productDto.getPrice() != null) savedProduct.setPrice(productDto.getPrice());
        if (productDto.getQuantity() != null) savedProduct.setQuantity(productDto.getQuantity());
        return savedProduct;
    }

    public void destroy(Long id) {
        repository.deleteById(id);
    }
}
