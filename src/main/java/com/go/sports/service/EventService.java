package com.go.sports.service;

import com.go.sports.dto.mapper.EventMapper;
import com.go.sports.dto.request.EventDTO;
import com.go.sports.entity.Event;
import com.go.sports.exception.EventNotFoundException;
import com.go.sports.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventDTO> getAllEvents(){
        List<Event> events = eventRepository.findAll();
        return events.stream().map(EventMapper::toDTO).collect(Collectors.toList());
    }

    public EventDTO getEventById(String id) throws EventNotFoundException {
          return EventMapper.toDTO(getEventFindById(id).get());
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event =  eventRepository.save(EventMapper.toModel(eventDTO));
        return EventMapper.toDTO(event);
    }

    public void deleteEvent(String id) throws EventNotFoundException {
       Optional<Event> event = getEventFindById(id);
       if(event.isPresent()){
           eventRepository.delete(event.get());
       }
    }

    private Optional<Event> getEventFindById(String id) throws EventNotFoundException {
        return  Optional.ofNullable(eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id)));
    }
}
