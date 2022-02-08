package com.go.sports.controller;

import com.go.sports.dto.request.CategoryDTO;
import com.go.sports.exception.CategoryNotFoundException;
import com.go.sports.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categories;
        categories = categoryService.getAllCategory();
        return categories;
    }

    @GetMapping("/event/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getCategoriesByEvent(@PathVariable(name = "id") String eventId) {
        List<CategoryDTO> categories;
        categories = categoryService.getCategoryByEventId(eventId);
        return categories;
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteCategory(@PathVariable(name = "id") String categoryId) throws CategoryNotFoundException {
//        categoryService.deleteCategory(categoryId);
//    }
}
