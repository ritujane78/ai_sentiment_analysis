# AI Sentiment Analysis

An AI-powered Sentiment Analysis application built with **React** for the frontend and **Spring Boot + Spring AI** for the backend.  
The application analyzes customer/product feedback using **OpenAI GPT-4o-nano** and returns:

- Sentiment Type (Positive, Negative, Neutral)
- Sentiment Score

---

# Tech Stack

## Frontend
- ReactJS
- Vite
- TailwindCSS
- Axios

## Backend
- Spring Boot
- Spring AI
- OpenAI Chat Model (`gpt-4o-nano`)
- Maven

---

# Project Overview

This project demonstrates how Artificial Intelligence can be integrated into a modern full-stack application to perform intelligent sentiment analysis on user feedback.

Users can submit product or customer feedback from the React frontend, and the Spring Boot backend processes the feedback using OpenAI's language model.

The AI understands the context, tone, and meaning of the feedback and returns:
- A sentiment classification
- A confidence/score
- AI interpretation of the review

---

# How AI is Used

The backend uses **Spring AI** to connect with OpenAI's chat model (`gpt-4o-nano`).

Instead of relying on traditional keyword-based sentiment analysis, the application uses an LLM (Large Language Model) to understand:
- Emotions
- Context
- Intent
- Tone of the feedback

Example:

## Input

```text
"The watch is compketely reliable and lasts for years."
```

## AI Response

```json
{
  "sentiment": "POSITIVE",
  "score": 0.9,
  "content": "The watch is compketely reliable and lasts for years."
  "createdAt":2026-05-26T10:30:00
}
---

#  Frontend + Backend Integration

The React frontend communicates with the Spring Boot backend through REST APIs.

Example flow:

```text
React Frontend
      ↓
Spring Boot REST API
      ↓
Spring AI
      ↓
OpenAI GPT-4o-nano
      ↓
Sentiment Result Returned
```

---

#  CORS Issue During Integration

While integrating React with Spring Boot, a common issue encountered was:

```text
CORS Policy Error
```

This happens because:
- React frontend runs on a different port (e.g. `localhost:5173`)
- Spring Boot backend runs on another port (e.g. `localhost:8080`)

Browsers block requests between different origins unless explicitly allowed.

## Solution

CORS was enabled in the Spring Boot controller using:

```java
@CrossOrigin("http://localhost:5173")
```

# Running the Project

## Backend Setup

### 1. Navigate to backend folder

```bash
cd spring-ai-open-ai
```

### 2. Configure OpenAI API Key

Add your API key inside:

```properties
application.properties
```

```properties
spring.ai.openai.api-key=YOUR_API_KEY
```

### 3. Run the Spring Boot application

```bash
mvn spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

---

## Frontend Setup

### 1. Navigate to frontend folder

```bash
cd sentiment-analysis-fe
```

### 2. Install dependencies

```bash
npm install
```

### 3. Start development server

```bash
npm run dev
```

Frontend runs on:

```text
http://localhost:5173
```