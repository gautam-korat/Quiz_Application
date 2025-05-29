package com.example.Quiz_Application.DTO;

public class UserAnswerDTO
{
    private Long answerId;
    private Long userId;
    private Long questionId;
    private char answer;

    // Default Constructor
    public UserAnswerDTO()
    {

    }

    // Parameterized Constructor
    public UserAnswerDTO(Long answerId, Long userId, Long questionId, char answer) {
        this.answerId = answerId;
        this.userId = userId;
        this.questionId = questionId;
        this.answer = answer;
    }

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

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}