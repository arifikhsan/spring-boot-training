package com.example.demo.controller;

import com.example.demo.dto.BuyProductDto;
import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.UpdateStockRequestDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import com.example.demo.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {
    ProductService productService;
    StaffService staffService;

    public ProductController(ProductService productService, StaffService staffService) {
        this.productService = productService;
        this.staffService = staffService;
    }

    @GetMapping("")
    public List<ProductEntity> getProducts(@RequestParam(value = "inStock", defaultValue = "0") boolean inStock) {
        return productService.fetchAll(inStock);
    }

    @GetMapping("{id}")
    public ProductEntity getProduct(@PathVariable("id") long id) throws Exception {
        return productService.one(id);
    }

    @PostMapping("")
    public ProductEntity addProduct(@RequestBody ProductDto productDto) {
        return productService.add(productDto);
    }

    @PutMapping("/stock")
    public ProductEntity updateStock(@RequestBody UpdateStockRequestDto requestDto) throws Exception {
        return productService.updateStock(requestDto);
    }

    @DeleteMapping("{id}")
    public CommonResponse deleteProduct(@PathVariable("id") long id) {
        productService.delete(id);
        return new CommonResponse("Successfully delete product");
    }

    @PostMapping("{id}/buy")
    public ProductEntity buy(
            @PathVariable("id") long id,
            @RequestBody BuyProductDto body
    ) throws Exception {
        return productService.buy(id, body);
    }
}
