package com.example.Quiz_Application.DTO;
import java.time.LocalDateTime;

public class UserQuizSessionDTO
{
    private Long sessionId;
    private Long userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    // Default Constructor
    public UserQuizSessionDTO()
    {

    }

    // Parameterized Constructor
    public UserQuizSessionDTO(Long sessionId, Long userId, LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}