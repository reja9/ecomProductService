package dev.reja.ecomProductService.ecomProductService.services;

import dev.reja.ecomProductService.ecomProductService.dtos.CreateCategoryDto;
import dev.reja.ecomProductService.ecomProductService.exceptions.CategoryNotFoundException;
import dev.reja.ecomProductService.ecomProductService.models.Category;
import dev.reja.ecomProductService.ecomProductService.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(CreateCategoryDto createCategoryDto) {
        Category category=new Category();
        category.setCategoryName(createCategoryDto.getCategoryName());
        return categoryRepository.save(category);
    }

    @Override
    public Category getById(UUID categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category for this "+categoryId+" is not presenmt")
        );
    }
}
