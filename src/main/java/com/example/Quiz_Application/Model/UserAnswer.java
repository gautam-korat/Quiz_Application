package com.example.Quiz_Application.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_answer")
public class UserAnswer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answerId;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserInformation user;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private UserQuizSession session;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "answer",nullable = false)
    private char answer;

    // default Constructor
    public UserAnswer()
    {

    }

    // parameterized constructor

    public UserAnswer(Long answerId, UserInformation user, UserQuizSession session, Question question, char answer) {
        this.answerId = answerId;
        this.user = user;
        this.session = session;
        this.question = question;
        this.answer = answer;
    }

    // getter setter

    public char getAnswer() {
        return answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public UserQuizSession getSession() {
        return session;
    }

    public void setSession(UserQuizSession session) {
        this.session = session;
    }

    public UserInformation getUser() {
        return user;
    }

    public void setUser(UserInformation user) {
        this.user = user;
    }
}