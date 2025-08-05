package com.ramesh.learningtracker.repository;

import com.ramesh.learningtracker.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
