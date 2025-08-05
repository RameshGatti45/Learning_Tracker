package com.ramesh.learningtracker.repository;

import com.ramesh.learningtracker.model.StudySession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {
    List<StudySession> findByDateBetween(LocalDate start, LocalDate end);
}
