package com.go.sports.dto;

import com.go.sports.entity.Category;
import com.go.sports.entity.Event;
import com.go.sports.enums.EventType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;


@Setter
@Getter
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

    public EventDTO(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.eventType = event.getEventType();
    }

    public EventDTO() {
    }

    public static List<EventDTO> converter(List<Event> events) {
        return events.stream().map(EventDTO::new).collect(Collectors.toList());
    }

    public Event convertToEntity() {
        Event event = new Event();
        event.setEventType(this.eventType);
        event.setDescription(this.description);
        event.setTitle(this.title);

        List<Category> list = categories.stream().map((ca) -> new Category(ca)).collect(Collectors.toList());
        list.stream().forEach(s -> {
            s.setEvent(event);
        });
        event.setCategories(list);
        return event;
    }

    private List<Category> setupCategoryListFromDTO(List<CategoryDTO> categories, Event event) {
        List<Category> list = categories.stream().map((ca) -> new Category(ca)).collect(Collectors.toList());
        list.stream().forEach(s -> {
            s.setEvent(event);
        });
        return list;
    }
}
