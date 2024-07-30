package dev.reja.ecomProductService.ecomProductService.controllers;


import dev.reja.ecomProductService.ecomProductService.dtos.CreateProductDto;
import dev.reja.ecomProductService.ecomProductService.models.Product;
import dev.reja.ecomProductService.ecomProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findByCategory/{categoryId}")
    public ResponseEntity findByCategoryId(@PathVariable("categoryId") UUID categoryId){

        return ResponseEntity.ok(productService.findByCategoryId(categoryId));
    }

    @GetMapping
    public ResponseEntity findAllProducts(){
        return ResponseEntity.ok(productService.getAllproducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity findByProductId(@PathVariable("productId") UUID productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody CreateProductDto createProductDto){
        return ResponseEntity.ok(productService.createProduct(createProductDto));
    }
}
