package com.jane.sentiment.service;

import com.jane.sentiment.entity.Feedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class FeedbackAnalysisService {
    private final ChatClient chatClient;
    private static final Logger logger = LoggerFactory.getLogger(FeedbackAnalysisService.class);

    public FeedbackAnalysisService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public Feedback analyzeFeedback(String content) {
        String prompt = String.format("""
            Analyze the following text and determine if it is positive, negative, or neutral. 
            Provide a sentiment score between -1  and 1 where,
           -1 is the most negative
            0 is neutral
            1 is the most positive
           
           Format the response as SENTIMENT_TYPE|SENTIMENT_SCORE 
            
            Text to analyze: "%s"
            """, content);

        String response = chatClient
                .prompt(prompt)
                .call()
                .content();
        logger.info("Feedback analysis response: {}", response);

        String[] parts= response.split("\\|");

        Feedback feedback = new Feedback();
        feedback.setContent(content);
        feedback.setSentiment(Feedback.SentimentType.valueOf(parts[0].trim()));
        feedback.setSentimentScore(Double.parseDouble(parts[1].trim()));
        System.out.println("Feedback analysis result of " +feedback.getContent() + ": ");

        return feedback;
    }
}
