package org.example.service;

import org.example.model.mls.MessageLogs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MessageLogsServiceImplTest {

    MessageLogs messageLogs;
    @Autowired
    MessageLogsService messageLogsService;

    @BeforeEach
    void setUp() {
        messageLogs=new MessageLogs();
        messageLogs.setClientCode("XYZ");
        messageLogs.setPayload("Message test");

    }

    @Test
    public void testCreateMessageLogs(){
        MessageLogs messageLogs1=messageLogsService.createMessageLogs(messageLogs);
        assertNotNull(messageLogs1);
        assertEquals(messageLogs1.getClientCode(),"XYZ");
    }


}