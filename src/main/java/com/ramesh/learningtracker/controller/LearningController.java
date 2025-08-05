package com.ramesh.learningtracker.controller;

import com.ramesh.learningtracker.service.LearningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LearningController {

    private final LearningService service;

    //Home Page - list subjects and last 7 days' sessions
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("subjects", service.getAllSubjects());
        model.addAttribute("sessions", service.getSessionsLast7Days());
        return "home"; // maps to home.html
    }

    //Add new subject
    @PostMapping("/addSubject")
    public String addSubject(@RequestParam String name) {
        service.addSubject(name);
        return "redirect:/";
    }

    //Log study time
    @PostMapping("/logStudyTime")
    public String logStudyTime(@RequestParam Long subjectId, @RequestParam int minutes) {
        service.logStudyTime(subjectId, minutes);
        return "redirect:/";
    }
}
