package dev.reja.ecomProductService.ecomProductService.services;

import dev.reja.ecomProductService.ecomProductService.dtos.CreateProductDto;
import dev.reja.ecomProductService.ecomProductService.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    public List<Product> getAllproducts();
    public List<Product> findByCategoryId(UUID categoryId);
    public Product createProduct(CreateProductDto createProductDto);

    public Product getProductById(UUID productId);
}
