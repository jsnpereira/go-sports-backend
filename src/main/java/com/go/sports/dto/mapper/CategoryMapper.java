package com.go.sports.dto.mapper;

import com.go.sports.dto.request.CategoryDTO;
import com.go.sports.entity.Category;
import org.springframework.data.domain.Page;

public class CategoryMapper {

    public static Category toModel(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setTitle(categoryDTO.getTitle());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }

    public static CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setTitle(category.getTitle());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }

    public static Page<CategoryDTO> mapPageToDTO( Page<Category> source){
        return source.map(CategoryMapper::toDTO);
    }

}
