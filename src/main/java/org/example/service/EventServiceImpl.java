package org.example.service;

import org.example.model.mulligan.Event;
import org.example.repository.mulligan.EventRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository eventRepository;

    @Autowired
    AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange}")
    String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    @Override
    public Event createEvent(Event event) {
        amqpTemplate.convertAndSend(exchange,routingkey,event.getReplayedMessages().get(0));
        return eventRepository.save(event);
    }

}
