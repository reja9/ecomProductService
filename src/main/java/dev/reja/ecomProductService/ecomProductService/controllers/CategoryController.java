package dev.reja.ecomProductService.ecomProductService.controllers;

import dev.reja.ecomProductService.ecomProductService.dtos.CreateCategoryDto;
import dev.reja.ecomProductService.ecomProductService.models.Category;
import dev.reja.ecomProductService.ecomProductService.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity getAllCategory(){

        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PostMapping
    public ResponseEntity createCategory(@RequestBody  CreateCategoryDto createCategoryDto){
        return ResponseEntity.ok(categoryService.createCategory(createCategoryDto));
    }

    @GetMapping("{id}")
    public ResponseEntity getCategoryById(@PathVariable("id")UUID categoryId){
        return ResponseEntity.ok(categoryService.getById(categoryId));
    }

}
