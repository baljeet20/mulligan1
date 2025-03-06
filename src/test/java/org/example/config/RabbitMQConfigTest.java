package org.example.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.amqp.core.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class RabbitMQConfigTest {

    @Autowired
    Queue queue;

    @Autowired
    DirectExchange exchange;

    @Test
    public void testQueueNotNull(){
        assertNotNull(queue);
    }

    @Test
    public void testExchangeNotNull(){
        assertNotNull(exchange);
    }

}