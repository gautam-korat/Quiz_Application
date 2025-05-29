package com.example.Quiz_Application.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionDTO {
    private Long questionId;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private Character correctOption;
    private String message;

    // Default Constructor
    public QuestionDTO() {

    }

    // Parameterized Constructor
    public QuestionDTO(Long questionId, String question, String optionA, String optionB, String optionC, String optionD, char correctOption) {
        this.questionId = questionId;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    // parameterized Constructor for message

    public QuestionDTO(String message)
    {
        this.message = message;
    }

    // send only message for user
    public static QuestionDTO onlyMessage(String message)
    {
        return new QuestionDTO(message);
    }

    // getter setter
    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Character getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(Character correctOption) {
        this.correctOption = correctOption;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}