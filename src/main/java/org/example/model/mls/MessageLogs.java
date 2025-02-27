package org.example.model.mls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "message_logs")
@Getter
@Setter
@NoArgsConstructor
public class MessageLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "client_code")
    private String clientCode;

    @Column(name = "payload")
    private String payload;
}
