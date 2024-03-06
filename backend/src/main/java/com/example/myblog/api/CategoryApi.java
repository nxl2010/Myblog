package com.example.myblog.api;

import com.example.myblog.enity.Category;
import com.example.myblog.service.impl.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/category")
public class CategoryApi {
    private final CategoryService categoryService;

    public CategoryApi(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    private List<Category> findAll(){
        return categoryService.findAll();
    }

    @PostMapping
    private ResponseEntity<Category> addCategory(@RequestBody Category category){
        categoryService.save(category);
        return ResponseEntity.ok().body(category);
    }
}
