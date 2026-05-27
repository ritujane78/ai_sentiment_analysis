package com.jane.sentiment.repository;

import com.jane.sentiment.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository  extends JpaRepository<Feedback, Long> {
}
