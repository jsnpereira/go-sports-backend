package com.go.sports.controller;

import com.go.sports.dto.CategoryDTO;
import com.go.sports.entity.Category;
import com.go.sports.entity.Event;
import com.go.sports.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{event_id}")
    public ResponseEntity<List<CategoryDTO>> getCategoriesByEvent(@PathVariable("event_id") String eventId) {
        List<Category> categories = categoryService.getCategoryByEventId(eventId);
        return ResponseEntity.ok(CategoryDTO.converter(categories));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(@RequestParam(name = "eventId", defaultValue = "") String eventId) {
        List<Category> categories;
        if (eventId.isBlank() || eventId.isEmpty()) {
            categories = categoryService.getAllCategory();
        } else {
            categories = categoryService.getCategoryByEventId(eventId);
        }
        return ResponseEntity.ok(CategoryDTO.converter(categories));
    }
}
