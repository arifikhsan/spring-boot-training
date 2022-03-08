package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("")
    public Iterable<ProductEntity> getProducts() {
        return service.all();
    }

    @GetMapping("{id}")
    public ProductEntity getProduct(@PathVariable("id") Long id) {
        return service.one(id);
    }

    @PostMapping("")
    public ProductEntity addProduct(@RequestBody ProductDto productDto) {
        return service.create(productDto);
    }

    @PutMapping("{id}")
    public ProductEntity updateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductDto productDto
    ) {
        return service.update(id, productDto);
    }

//    @PutMapping("/stock")
//    public CommonResponse updateStock() {
//        return service.update()
//    }

    @DeleteMapping("{id}")
    public CommonResponse deleteProduct(@PathVariable("id") Long id) {
        service.destroy(id);
        return new CommonResponse("Successfully delete product");
    }
}
