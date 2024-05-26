package com.apica.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apica.journal.entity.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}