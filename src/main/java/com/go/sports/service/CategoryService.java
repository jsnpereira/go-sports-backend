package com.go.sports.service;

import com.go.sports.dto.mapper.CategoryMapper;
import com.go.sports.dto.request.CategoryDTO;
import com.go.sports.entity.Category;
import com.go.sports.entity.Event;
import com.go.sports.exception.CategoryNotFoundException;
import com.go.sports.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategoryByEventId(String eventId) {
        Event event = new Event();
        event.setId(eventId);
        List<Category> categories = categoryRepository.findByEvent(event);
        return categories.stream().map(CategoryMapper::toDTO).collect(Collectors.toList());
    }

    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::toDTO).collect(Collectors.toList());
    }

    public void deleteCategory(String categoryId) throws CategoryNotFoundException {
        Optional<Category> category = getCategoryById(categoryId);
        if (category.isPresent()){
            categoryRepository.delete(category.get());
        }
    }

    private Optional<Category>  getCategoryById(String id) throws CategoryNotFoundException {
        return Optional.ofNullable(categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id)));
    }
}
