package dev.reja.ecomProductService.ecomProductService.services;

import dev.reja.ecomProductService.ecomProductService.dtos.CreateCategoryDto;
import dev.reja.ecomProductService.ecomProductService.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    public List<Category> getAllCategory();
    public Category createCategory(CreateCategoryDto createCategoryDto);
    public Category getById(UUID categoryId);
}
