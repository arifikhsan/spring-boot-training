package com.example.demo.service;

import com.example.demo.dto.BuyProductDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.UpdateStockRequestDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.TransactionEntity;
import com.example.demo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);
    ProductRepository repository;
    StaffService staffService;
    TransactionService transactionService;

    public ProductService(ProductRepository repository, StaffService staffService, TransactionService transactionService) {
        this.repository = repository;
        this.staffService = staffService;
        this.transactionService = transactionService;
    }

    public ProductEntity add(ProductDto request) {
        ProductEntity product = new ProductEntity();
        product.setProductName(request.getProductName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        return repository.save(product);
    }

    public List<ProductEntity> fetchAll(boolean isAvailableOnly) {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        if (isAvailableOnly) {
            return repository.findByStockGreaterThan(0);
        } else {
            //fetch all
            return (List<ProductEntity>) repository.findAll();
        }
    }

    public ProductEntity one(long id) throws Exception {
        var productOption = repository.findById(id);
        if (productOption.isEmpty()) throw new Exception("Produk tidak ditemukan");
        return productOption.get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public ProductEntity updateStock(UpdateStockRequestDto requestDto) throws Exception {
        ProductEntity product = one(requestDto.getId());
        product.setStock(requestDto.getStock());
        return repository.save(product);
    }

    @Transactional
    public ProductEntity buy(long id, BuyProductDto body) throws Exception {
        var product = one(id);
        var staff = staffService.one(body.getStaffId());
        if (staff.getBalance() < (product.getPrice() * body.getQuantity())) throw new Exception("Saldo tidak cukup");
        staff.setBalance((int) (staff.getBalance() - (product.getPrice() * body.getQuantity())));
        product.setStock(product.getStock() - body.getQuantity());
        transactionService.create(new TransactionEntity(staff, product, body.getQuantity()));
        return product;
    }
}
