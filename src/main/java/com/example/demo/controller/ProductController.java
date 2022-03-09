package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.dto.UpdateStockDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

//    @GetMapping("")
//    public List<ProductEntity> getProducts(
//            @RequestParam(value = "inStock", defaultValue = "0") Boolean isInStock
//    ) {
//        return isInStock ? service.fetch(isInStock) : service.all();
//    }

    @GetMapping
    public List<ProductEntity> getProducts(
            @RequestParam(value = "max-price", required = false) Long price
    ) {
        return price != null ? service.allWithMaxPrice(price) : service.all();
    }

    @GetMapping("{id}")
    public ProductResponseDto getProduct(@PathVariable("id") Long id) throws Exception {
        return new ProductResponseDto(service.one(id));
    }

    @PostMapping("")
    public ProductEntity addProduct(@RequestBody ProductDto productDto) {
        return service.create(productDto);
    }

    @PutMapping("{id}")
    public ProductEntity updateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductDto productDto
    ) throws Exception {
        return service.update(id, productDto);
    }

    @PutMapping("{id}/stock")
    public ProductEntity updateStock(@Valid @RequestBody UpdateStockDto updateStockDto) throws Exception {
        return service.updateStock(updateStockDto);
    }

    @DeleteMapping("{id}")
    public CommonResponse deleteProduct(@PathVariable("id") Long id) {
        service.destroy(id);
        return new CommonResponse("Successfully delete product");
    }
}
