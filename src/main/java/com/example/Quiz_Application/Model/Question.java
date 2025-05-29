package com.example.Quiz_Application.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")

public class Question
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "question",nullable = false,unique = true)
    private String question;

    @Column(name = "option_a",nullable = false)
    private String optionA;

    @Column(name = "option_b",nullable = false)
    private String optionB;

    @Column(name = "option_c",nullable = false)
    private String optionC;

    @Column(name = "option_d",nullable = false)
    private String optionD;

    @Column(name = "correct_option",nullable = false)
    private char correctOption;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserAnswer> userAnswers;

    // default Constructor
    public Question()
    {

    }
    // parameterized constructor

    public Question(Long questionId, String question, String optionA, String optionB, String optionC, String optionD, char correctOption) {
        this.questionId = questionId;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    // getter setter

    public char getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(char correctOption) {
        this.correctOption = correctOption;
    }

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

    public List<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }
}