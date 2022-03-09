package com.go.sports.dto.mapper;

import com.go.sports.dto.request.CategoryDTO;
import com.go.sports.dto.request.EventDTO;
import com.go.sports.entity.Category;
import com.go.sports.entity.Event;

import java.util.List;
import java.util.stream.Collectors;

public class EventMapper {

    public static EventDTO toDTO(Event event) {
        return toDTO(event, true);
    }

    public static EventDTO toDTO(Event event,boolean displayCategory) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setTitle(event.getTitle());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setEventType(event.getEventType());
        if (displayCategory){
            List<CategoryDTO> categories = event.getCategories().stream()
                    .map(CategoryMapper::toDTO).collect(Collectors.toList());
            eventDTO.setCategories(categories);
        }
        return eventDTO;
    }

    public static Event toModel(EventDTO eventDTO) {
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setTitle(eventDTO.getTitle());
        event.setDescription(eventDTO.getDescription());
        event.setEventType(eventDTO.getEventType());
        List<Category> categories = eventDTO.getCategories().stream()
                .map(CategoryMapper::toModel).collect(Collectors.toList());
        categories.stream().forEach(s -> {
            s.setEvent(event);
        });
        event.setCategories(categories);
        return event;
    }


}
