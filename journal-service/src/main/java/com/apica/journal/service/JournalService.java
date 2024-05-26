package com.apica.journal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apica.journal.entity.Journal;
import com.apica.journal.repository.JournalRepository;

@Service
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }
}
