package com.go.sports.dto.request;

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
public class CategoryPostDTO {
    private String id;
    @NotNull @NotEmpty @Size(min = 5, max = 20)
    private String title;
    @NotNull @NotEmpty @Size(min = 5, max = 40)
    private  String description;
    @NotNull @NotEmpty
    private String eventId;

}
