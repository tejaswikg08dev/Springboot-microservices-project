package com.apica.journal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apica.journal.entity.Journal;
import com.apica.journal.service.JournalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/journals")
@Tag(name = "Journals Controller", description = "Endpoint for journals")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @GetMapping
    @Operation(summary = "Get all Journals")
    public ResponseEntity<List<Journal>> getAllJournals() {
        return ResponseEntity.ok(journalService.getAllJournals());
    }
}
