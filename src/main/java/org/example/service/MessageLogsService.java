package org.example.service;

import org.example.model.mls.MessageLogs;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MessageLogsService {

    public MessageLogs createMessageLogs(MessageLogs messageLogs);
    public List<MessageLogs> getMessageLogs(String sql);
}
