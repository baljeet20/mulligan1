package org.example.repository.mls;

import org.example.model.mls.MessageLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageLogsRepository extends JpaRepository<MessageLogs, Long> {
}
