package dev.reja.ecomProductService.ecomProductService.services;

import dev.reja.ecomProductService.ecomProductService.dtos.CreateProductDto;
import dev.reja.ecomProductService.ecomProductService.exceptions.CategoryNotFoundException;
import dev.reja.ecomProductService.ecomProductService.exceptions.ProductNotFoundException;
import dev.reja.ecomProductService.ecomProductService.models.Category;
import dev.reja.ecomProductService.ecomProductService.models.Product;
import dev.reja.ecomProductService.ecomProductService.repositories.CategoryRepository;
import dev.reja.ecomProductService.ecomProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Product> getAllproducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByCategoryId(UUID categoryId) {
        return productRepository.findByCategoryId(categoryId).orElseThrow(
                () ->new ProductNotFoundException("No product found for this Category Id"+categoryId)
        );
    }

    @Override
    public Product createProduct(CreateProductDto createProductDto) {
        Product product=new Product();
        product.setProductName(createProductDto.getProductName());
        product.setPrice(createProductDto.getPrice());
        product.setImageUrl(createProductDto.getImageUrl());
        Category category=categoryRepository.findById(createProductDto.getCategoryId()).orElseThrow(
                () -> new CategoryNotFoundException("No Category found for this category Id"+createProductDto.getCategoryId())
        );
        product.setCategory(category);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProductById(UUID productId) {
        return productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("No product found for this Product Id"+productId)
        );
    }
}
