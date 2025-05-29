package com.example.Quiz_Application.DTO;

public class QuizResultDTO
{
    private int totalQuestion;
    private int correctAnswer;
    private int wrongAnswer;
    private String status;

    // Default Constructor
    public QuizResultDTO()
   {

   }

    // Parameterized Constructor
    public QuizResultDTO(int totalQuestion, int correctAnswer, int wrongAnswer, String status)
    {
        this.totalQuestion = totalQuestion;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
        this.status = status;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public int getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(int wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }
}
