package org.example.service;

import org.example.model.mulligan.Event;
import org.example.model.mulligan.ReplayedMessages;
import org.example.model.mulligan.SQLLogs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EventServiceImplTest {

    Event event;
    @Autowired
    EventService eventService;

    @BeforeEach
    void setUp() {
        event=new Event();
        event.setTeamName("abc");
        event.setQueueName("queue");
        ReplayedMessages replayedMessages=new ReplayedMessages();
        replayedMessages.setMessage("Message 1");
        ReplayedMessages replayedMessages1=new ReplayedMessages();
        replayedMessages.setMessage("Message 2");
        List<ReplayedMessages> messages=new ArrayList<>();
        messages.add(replayedMessages);
        messages.add(replayedMessages1);
        event.setReplayedMessages(messages);
        SQLLogs sqlLogs=new SQLLogs();
        sqlLogs.setDescription("select * from ABC");
        sqlLogs.setEvent(event);
        event.setSqlLogs(sqlLogs);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createEvent() {
        Event event1=eventService.createEvent(event);
        assertNotNull(event1);
        assertEquals(event1.getId(),1l);
        assertEquals(event1.getSqlLogs().getId(),1l);
        assertEquals(event1.getReplayedMessages().size(),2);
        assertEquals(event1.getReplayedMessages().get(1).getId(),2);

    }
}