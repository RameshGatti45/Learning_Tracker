package com.ramesh.learningtracker.service;

import com.ramesh.learningtracker.model.Subject;
import com.ramesh.learningtracker.model.StudySession;
import com.ramesh.learningtracker.repository.SubjectRepository;
import com.ramesh.learningtracker.repository.StudySessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LearningService {

    private final SubjectRepository subjectRepo;
    private final StudySessionRepository sessionRepo;

    // Get all subjects
    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    //Add a new subject
    public void addSubject(String name) {
        subjectRepo.save(new Subject(null, name));
    }

    //Log time spent on a subject
    public void logStudyTime(Long subjectId, int minutes) {
        Subject subject = subjectRepo.findById(subjectId).orElseThrow();
        StudySession session = new StudySession(null, LocalDate.now(), minutes, subject);
        sessionRepo.save(session);
    }

    //Get sessions from last 7 days
    public List<StudySession> getSessionsLast7Days() {
        LocalDate today = LocalDate.now();
        LocalDate weekAgo = today.minusDays(6);
        return sessionRepo.findByDateBetween(weekAgo, today);
    }
}
