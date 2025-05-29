package com.example.Quiz_Application.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_quiz_session")
public class UserQuizSession
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long sessionId;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserInformation user;

    @Column(name = "start_time",nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "session",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAnswer> userAnswers;

    public enum Status
    {
        ACTIVE,COMPLETE;
    }

    // default Constructor

    public UserQuizSession()
    {

    }

    // parameterized constructor

    public UserQuizSession(Long sessionId, UserInformation user, LocalDateTime startTime, LocalDateTime endTime, Status status) {
        this.sessionId = sessionId;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    // getter setter

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserInformation getUser() {
        return user;
    }

    public void setUser(UserInformation user) {
        this.user = user;
    }

    public List<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }
}