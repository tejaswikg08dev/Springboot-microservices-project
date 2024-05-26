package com.apica.journal.kafka;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apica.journal.entity.Journal;
import com.apica.journal.repository.JournalRepository;

@Service
public class KafkaConsumerService {
    @Autowired
    private JournalRepository journalRepository;

    @KafkaListener(topics = "user-events", groupId = "journal-group")
    public void listen(String message) {
        Journal journal = new Journal();
        journal.setEvent(message);
        journal.setTimestamp(LocalDateTime.now());
        journalRepository.save(journal);
    }
}
