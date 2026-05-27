package com.jane.sentiment.controller;

import com.jane.sentiment.entity.Feedback;
import com.jane.sentiment.repository.FeedbackRepository;
import com.jane.sentiment.service.FeedbackAnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:5173")
public class FeedbackController {
    private final FeedbackRepository feedbackRepository;
    private final FeedbackAnalysisService service;

    public FeedbackController(FeedbackRepository feedbackRepository, FeedbackAnalysisService service) {
        this.feedbackRepository = feedbackRepository;
        this.service = service;
    }

    @GetMapping
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @PostMapping
    public Feedback save(@RequestBody String content) {
        Feedback feedback = service.analyzeFeedback(content);

        return feedbackRepository.save(feedback);
    }
}
