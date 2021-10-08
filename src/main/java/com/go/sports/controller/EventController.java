package com.go.sports.controller;

import com.go.sports.dto.EventDTO;
import com.go.sports.entity.Event;
import com.go.sports.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(EventDTO.converter(events));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable("id") String id, @RequestParam(name = "category", defaultValue = "false") Boolean category ) {
        Optional<Event> event = eventService.getEventById(id);
        if(event.isPresent()){
            return ResponseEntity.ok(new EventDTO(event.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EventDTO> postEvent(@RequestBody @Valid EventDTO eventDTO, UriComponentsBuilder uriBuilder) {
        Event event = eventService.createEvent(eventDTO.convertToEntity());
        URI uri = uriBuilder.path("/v1/events/{id}").buildAndExpand(event.getId()).toUri();
        return ResponseEntity.created(uri).body(new EventDTO(event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") String id) {
        Optional<Event> event = eventService.getEventById(id);
        if(event.isPresent()){
            eventService.deleteEvent(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
