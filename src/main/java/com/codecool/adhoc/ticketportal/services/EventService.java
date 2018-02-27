package com.codecool.adhoc.ticketportal.services;

import com.codecool.adhoc.ticketportal.model.Event;
import com.codecool.adhoc.ticketportal.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    public Event findById(Long id){
        return eventRepository.findOne(id);
    }

    public void saveEvent(Event event){
        eventRepository.save(event);
    }
}
