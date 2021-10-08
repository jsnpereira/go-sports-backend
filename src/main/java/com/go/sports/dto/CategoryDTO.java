package com.go.sports.dto;

import com.go.sports.entity.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class CategoryDTO {
    private String id;
    @NotNull @NotEmpty @Size(min = 5, max = 20)
    private String title;
    @NotNull @NotEmpty @Size(min = 5, max = 40)
    private  String description;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.description = category.getDescription();
    }

    public CategoryDTO() {
    }

    public static List<CategoryDTO> converter(List<Category> categories){
        return categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

}
