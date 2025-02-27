package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.model.mls.MessageLogs;
import org.example.repository.mls.MessageLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageLogsServiceImpl implements MessageLogsService{

    @Autowired
    @Qualifier("secondaryEntityManagerFactory")
    EntityManager entityManager;

    @Autowired
    MessageLogsRepository messageLogsRepository;

    @Override
    public MessageLogs createMessageLogs(MessageLogs messageLogs) {
        return messageLogsRepository.save(messageLogs);
    }

    @Override
    public List<MessageLogs> getMessageLogs(String sql) {
        return  entityManager.createNativeQuery(sql).getResultList();
    }


}
