package com.go.sports.controller;

import com.go.sports.dto.request.EventDTO;

import com.go.sports.exception.EventNotFoundException;
import com.go.sports.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EventDTO> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EventDTO getEventById(@PathVariable("id") String id, @RequestParam(name = "category",
            defaultValue = "false") Boolean category) throws EventNotFoundException {
        return eventService.getEventById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventDTO postEvent(@RequestBody @Valid EventDTO eventDTO, UriComponentsBuilder uriBuilder) {
        return eventService.createEvent(eventDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = "EventsList", allEntries = true)
    public void deleteEvent(@PathVariable("id") String id) throws EventNotFoundException {
        eventService.deleteEvent(id);
    }
}
