package com.go.sports.service;

import com.go.sports.controller.CategoryController;
import com.go.sports.entity.Category;
import com.go.sports.entity.Event;
import com.go.sports.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategoryByEventId(String eventId){
        Event event = new Event();
        event.setId(eventId);
        return categoryRepository.findByEvent(event);
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
