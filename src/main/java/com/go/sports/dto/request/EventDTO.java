package com.go.sports.dto.request;

import com.go.sports.entity.Category;
import com.go.sports.entity.Event;
import com.go.sports.enums.EventType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;


@Setter
@Getter
@NoArgsConstructor
public class EventDTO {
    private String id;
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 30)
    private String title;
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 200)
    private String description;
    @NotNull
    private EventType eventType;
    private List<CategoryDTO> categories;
}
