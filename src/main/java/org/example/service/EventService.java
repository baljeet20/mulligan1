package org.example.service;

import org.example.model.Event;
import org.springframework.stereotype.Service;

public interface EventService {

    public Event createEvent(Event event);
}
