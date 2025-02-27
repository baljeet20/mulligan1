package org.example.model.mulligan;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "event")
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "queue_name")
    private String queueName;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    private SQLLogs sqlLogs;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReplayedMessages> replayedMessages;

}
