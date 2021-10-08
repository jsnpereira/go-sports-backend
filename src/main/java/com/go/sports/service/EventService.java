package com.go.sports.service;

import com.go.sports.entity.Event;
import com.go.sports.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }


    public Optional<Event> getEventById(String id) {
        return  eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(String id) {
        Event event = new Event();
        event.setId(id);
        eventRepository.delete(event);
    }
}
